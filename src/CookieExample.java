import javax.servlet.http.Cookie;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@javax.servlet.annotation.WebServlet(name = "CookieExample",urlPatterns = "/CookieExample")
public class CookieExample extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
       response.setContentType("text/html;charset=GBK");
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 hh时:mm分:ss秒");
        String format = sdf.format(date);
        String curTime=URLEncoder.encode(format,"GBK");
        Cookie c=new Cookie("lastTime",curTime);
        response.addCookie(c);
        Cookie[] cookies = request.getCookies();
        String lastTime=null; //用来判断cookie中有没有名字为lastTime的cookie
        if(cookies!=null) {
            for (Cookie cookie : cookies
                    ) {
                String name = cookie.getName();

                if (name.equals("lastTime")) {
                    lastTime=cookie.getValue();
                    lastTime=URLDecoder.decode(lastTime,"GBK");
                    response.getWriter().write("欢迎再次光临本网站，您上次访问的时间为：" +lastTime+"<br>");
                    response.getWriter().write("当前时间为:"+format);
                    //更新cookie
                    cookie.setValue(format);
                    response.addCookie(cookie);
                    break;
                }
            }
        }
        if(cookies==null||lastTime==null){
            response.getWriter().write("欢迎光临本网站，当前时间为"+format);
        }
    }
}
