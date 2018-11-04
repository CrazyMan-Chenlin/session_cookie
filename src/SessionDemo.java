import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "SessionDemo",urlPatterns = "/SessionDemo")
public class SessionDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //����session����
        HttpSession session = request.getSession(true);
        //���ù���ʱ��
        /*session.setMaxInactiveInterval(10);*/
        //���ùر���������Ự���ᶪʧ
        Cookie c=new Cookie("JSESSIONID",session.getId());
        c.setMaxAge(30*24*60*60);
        response.addCookie(c);
        session.setAttribute("name","chenlin");

    }
}
