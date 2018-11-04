package servlet;

import Dao.ProductDao;
import enity.product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "DetailProdServlet",urlPatterns = "/DetailProdServlet")
public class DetailProdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=GBK");
        String html="<html> <body> ";
        html+="<table  border='1px' width='200px' align='center'>";
        String id=request.getParameter("id");
        product product = ProductDao.getProduct(id);
        html+="<tr><th>商品编号</th>"+"<td>"+product.getId()+"</td></tr>";
        html+="<tr><th>商品名称</th>"+"<td>"+product.getName()+"</td></tr>";
        html+="<tr><th>商品类型</th>"+"<td>"+product.getType()+"</td></tr>";
        html+="<tr><th>商品价格</th>"+"<td>"+product.getPrice()+"</td></tr>";
        html+="<tr><td colspan='2' style='text-align: center'><a href='"+this.getServletContext().getContextPath()+"/ListProdServlet"+"'>返回商品列表</a></td></tr>";
        html+="</table>";
        html+="</body> </html>";
        Cookie c=new Cookie("prodHist",getCookieValue(request,product.getId()));
        response.addCookie(c);
        response.getWriter().write(html);

    }
    private String getCookieValue(HttpServletRequest request,String id) {
        Cookie[] cookies = request.getCookies();
        String prodHist=null;
        if (cookies!=null){
            for (Cookie c: cookies
                 ) {
                if (c.getName().equals("prodHist")){
                    prodHist=c.getValue();
                    break;
                }
            }
        }
        if (cookies==null|| prodHist==null){
            return id;
        }
        String[] split = prodHist.split("#");
        List<String> list = Arrays.asList(split);
        LinkedList<String> linkedList=new LinkedList(list);
        if(linkedList.size()<3){
            if (linkedList.contains(id)){
                linkedList.remove(id);
                linkedList.addFirst(id);
            }else{
                linkedList.addFirst(id);
            }
        }else{
            if (linkedList.contains(id)){
                linkedList.remove(id);
                linkedList.addFirst(id);
            }else {
                linkedList.remove(linkedList.size()-1);
                linkedList.addFirst(id);
            }
        }
        String str="";
        for (String s:linkedList
             ) {
            str+=s+"#";
        }
        str=str.substring(0,str.length()-1);
        return str;
    }
}
