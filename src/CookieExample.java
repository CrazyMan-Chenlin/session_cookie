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
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy��MM��dd�� hhʱ:mm��:ss��");
        String format = sdf.format(date);
        String curTime=URLEncoder.encode(format,"GBK");
        Cookie c=new Cookie("lastTime",curTime);
        response.addCookie(c);
        Cookie[] cookies = request.getCookies();
        String lastTime=null; //�����ж�cookie����û������ΪlastTime��cookie
        if(cookies!=null) {
            for (Cookie cookie : cookies
                    ) {
                String name = cookie.getName();

                if (name.equals("lastTime")) {
                    lastTime=cookie.getValue();
                    lastTime=URLDecoder.decode(lastTime,"GBK");
                    response.getWriter().write("��ӭ�ٴι��ٱ���վ�����ϴη��ʵ�ʱ��Ϊ��" +lastTime+"<br>");
                    response.getWriter().write("��ǰʱ��Ϊ:"+format);
                    //����cookie
                    cookie.setValue(format);
                    response.addCookie(cookie);
                    break;
                }
            }
        }
        if(cookies==null||lastTime==null){
            response.getWriter().write("��ӭ���ٱ���վ����ǰʱ��Ϊ"+format);
        }
    }
}
