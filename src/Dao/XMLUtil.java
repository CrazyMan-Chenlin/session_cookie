package Dao;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import java.io.File;


public class XMLUtil {
    public static Document getDocuemnt(){
        try {
            SAXReader reader = new SAXReader();
            Document doc=reader.read(new File("C:\\Users\\chenlin\\IdeaProjects2\\session£¦cookie\\web\\product.xml"));
            return  doc;
        } catch (DocumentException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public static Document getDocuemnt2(){
        try {
            SAXReader reader = new SAXReader();
            Document doc=reader.read(new File("C:\\Users\\chenlin\\IdeaProjects2\\session£¦cookie\\web\\user.xml"));
            return  doc;
        } catch (DocumentException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
