import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CookieDemo",urlPatterns = "/CookieDemo")
public class CookieDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             /*Cookie c=new Cookie("name","jacky");*/
             //中文传输
             Cookie c=new Cookie("name","张三");
             /*response.setHeader("set-cookie","name=jacky");*/
                //简化版本
        //设置有效路径
        c.setPath("/session&cookie");
        //设置有效时间
       /* c.setMaxAge(10);*/ //正数
      /* c.setMaxAge(-10);*/  //负数
       c.setMaxAge(0);
              response.addCookie(c);

        /*String cookie = request.getHeader("cookie");*/
        //简化版本
        Cookie[] cookies = request.getCookies();
        if (cookies!=null) {
            for (Cookie cookie : cookies
                    ) {
                String name = cookie.getName();
                String value = cookie.getValue();
                System.out.println(name + "=" + value);
            }
        }


    }
}
