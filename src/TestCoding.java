import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class TestCoding {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String gbk = URLDecoder.decode("%D5%C5%C8%FD", "GBK");
        System.out.println(gbk);

    }
}
