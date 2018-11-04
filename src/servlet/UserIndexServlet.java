package servlet;

import enity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "UserIndexServlet",urlPatterns = "/UserIndexServlet")
public class UserIndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession(false);
        if (session!=null){
          User user =(User) session.getAttribute("user");
          if(user!=null){
              response.getWriter().write("你好！"+user.getUsername()+"  "+"欢迎回来！<br>");
              response.getWriter().write("<a href='"+request.getContextPath()+"/OutLoginServlet"+"'>安全退出</a>");
          }else {
              response.sendRedirect(request.getContextPath()+"/Login.html");
          }
        }else {
            response.sendRedirect(request.getContextPath()+"/Login.html");
        }

    }
}
