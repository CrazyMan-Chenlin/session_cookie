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
import java.util.List;

@WebServlet(name = "ListProdServlet",urlPatterns = "/ListProdServlet")
public class ListProdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
              doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("text/html;charset=GBK");
            String html="<html> <body> ";
            html+="<table  border='1px' width='600px' align='center'>";
            html+="<tr>";
            html+="<th>商品编号</th>";
            html+="<th>商品名称</th>";
            html+="<th>商品类型</th>";
            html+="<th>价格</th>";
            html+="<th>查看详情</th>";
            html+="</tr>";
        List<product> allProduct = ProductDao.getAllProduct();
        for (product p: allProduct
             ) {
            html+="<tr>";
            html+="<td>"+p.getId()+"</td>";
            html+="<td>"+p.getName()+"</td>";
            html+="<td>"+p.getType()+"</td>";
            html+="<td>"+p.getPrice()+"</td>";
            //url传参数
            html+="<td>"+"<a href='"+this.getServletContext().getContextPath()+"/DetailProdServlet?id="+p.getId()+"'>查看</a>"+"</td>";

        }
        html+="</table>";
        html+="<hr>";
        html+="最近浏览过的商品<br>";
        Cookie[] cookies = request.getCookies();
        if (cookies!= null) {
            for (Cookie c : cookies
                    ) {
                if (c.getName().equals("prodHist")){
                    String value = c.getValue();
                    String[] split = value.split("#");
                    for (String str:split
                         ) {
                        product product = ProductDao.getProduct(str);
                        html+=product.getId()+"&nbsp;&nbsp;"+product.getName()+"&nbsp;&nbsp;"+product.getPrice()+"<br>";
                    }
                }
            }
        }
        html+="</body> </html>";
        response.getWriter().write(html);
    }
}
