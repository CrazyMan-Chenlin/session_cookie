package Dao;
import enity.User;
import org.dom4j.Document;
import org.dom4j.Element;

public class UserDao {
    public static User isUser(String username){
        Document doc = XMLUtil.getDocuemnt2();
        Element element = (Element) doc.selectSingleNode("//username[text()='"+username+"']");
         if (element!=null){
             User user=new User();
             Element userElm = element.getParent();
             user.setId(userElm.attributeValue("id"));
             user.setUsername(userElm.elementText("username"));
             user.setPassword(userElm.elementText("password"));
             return user;
         }
        return null;
    }

    public static void main(String[] args) {
        User chen = isUser("che");
        System.out.println(chen.toString());
    }
}
