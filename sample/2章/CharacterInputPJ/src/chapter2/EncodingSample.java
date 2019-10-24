import java.net.URLEncoder;
import java.net.URLDecoder;
public class EncodingSample{
  public static void main(String[] args){
    try{
      System.out.println("エンコードテスト："
       + URLEncoder.encode("おはよう","UTF-8"));
      System.out.println("デコードテスト："
       + URLDecoder.decode(
         "%E3%81%8A%E3%81%AF%E3%82%88%E3%81%86","UTF-8"));
    }catch(Exception e){
      System.out.println(e);
    }
  }
}
