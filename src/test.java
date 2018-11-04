import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
    public static void main(String[] args) {
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-ddhh:mm:ss");
        String format = sdf.format(date);
        System.out.println(format);
    }
}
