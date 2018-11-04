package servlet;

import enity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "OutLoginServlet",urlPatterns = "/OutLoginServlet")
public class OutLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession(false);
        if (session!=null){
            User user = (User) session.getAttribute("user");
            if (user!=null){
                session.removeAttribute("user");
                response.getWriter().write("退出成功！5秒后返回登录页面！");
                response.setHeader("refresh", "5;"+request.getContextPath()+"/Login.html");
            }else{
                response.sendRedirect(request.getContextPath()+"/Login.html");
            }
        }else{
            response.sendRedirect(request.getContextPath()+"/Login.html");
        }


    }
}
