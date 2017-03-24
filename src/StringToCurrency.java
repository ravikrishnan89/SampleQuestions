import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by ravi.krishnan on 20/11/16.
 */
public class StringToCurrency {


    String toCurrency(String number){
        StringBuilder sb = new StringBuilder();
        boolean count3 = true;
        int count=0;
        int i=number.length()-1;
        while(number.charAt(i)!='.'){
            sb.append(number.charAt(i--));
        }
        sb.append(number.charAt(i--));
        for(;i>=0;i--){

            if(count == 3){
                sb.append(",");
                count3 = false;
                count = 0;
            }
            sb.append(number.charAt(i));
            count++;
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("en","us"));
        System.out.println(nf.format(112323412345.67));
        System.out.println(new StringToCurrency().toCurrency("112323412345.67"));
    }
}
