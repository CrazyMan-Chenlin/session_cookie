import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "SessionDemo",urlPatterns = "/SessionDemo")
public class SessionDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //创建session对象
        HttpSession session = request.getSession(true);
        //设置过期时间
        /*session.setMaxInactiveInterval(10);*/
        //设置关闭浏览器，会话不会丢失
        Cookie c=new Cookie("JSESSIONID",session.getId());
        c.setMaxAge(30*24*60*60);
        response.addCookie(c);
        session.setAttribute("name","chenlin");

    }
}
