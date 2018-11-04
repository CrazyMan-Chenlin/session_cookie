package Dao;

import enity.product;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;

import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    public static List<product> getAllProduct(){
        Document doc = XMLUtil.getDocuemnt();
        List<product> list=new ArrayList();
        product p=null;
        List<Element> elelist=doc.getRootElement().elements("product");
        for (Element e: elelist
                ) {
            p=new product();
            p.setId(e.attribute("id").getValue());
            p.setName(e.elementText("name"));
            p.setType(e.elementText("type"));
            p.setPrice(e.elementText("price"));
            list.add(p);
        }
        return list;
    }
    public static product getProduct(String id){
        Document doc = XMLUtil.getDocuemnt();
        product p=new product();
        Element element = (Element) doc.selectSingleNode("//product[@id='" + id + "']");
        p.setId(element.attributeValue("id"));
        p.setName(element.elementText("name"));
        p.setType(element.elementText("type"));
        p.setPrice(element.elementText("price"));
        return p;
    }
    public static void main(String[] args) {
        product product = getProduct("1");
        System.out.println(product.toString());

    }
}
