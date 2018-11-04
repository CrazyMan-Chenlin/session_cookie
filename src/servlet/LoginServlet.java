package servlet;

import Dao.UserDao;
import enity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("Utf-8");
         response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = UserDao.isUser(username);
        if (user!=null){
            if (password.equals(user.getPassword())){
                HttpSession session = request.getSession(true);
                session.setAttribute("user",user);
                response.sendRedirect(request.getContextPath()+"/UserIndexServlet");
            }else{
                   response.getWriter().write("密码输入错误");
            }
        }else{
            response.getWriter().write("没有该用户！！！");
        }

    }
}
