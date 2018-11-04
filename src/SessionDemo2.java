import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SessionDemo2",urlPatterns = "/SessionDemo2")
public class SessionDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         //��ȡsession����
        HttpSession session = request.getSession(false);
        if (session==null){
            System.out.println("û��session����");
        }else{
            //��ȡsession������ֵ
            String name = (String)session.getAttribute("name");
            System.out.println(name);
        }


    }
}
