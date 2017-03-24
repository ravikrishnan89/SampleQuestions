import java.util.ArrayList;
import java.util.List;

/**
 * Created by ravi.krishnan on 24/01/17.
 */
public class GeneratePermsStrings {
    public static List<String> generatePerm(String str){
        List<String> strings = new ArrayList<>();
        generatePerm(str.toCharArray(),0,strings);
        return strings;
    }

    public static void generatePerm(char [] str, int start, List<String> strings){
        if(start == str.length -1){
            strings.add(new String(str));
            return;
        }
        for(int i=start;i<str.length;i++){
            swap(str,i,start);
            generatePerm(str,start+1, strings);
            swap(str,i,start);
        }
    }

    public static void swap(char [] str,int a, int b) {
        char temp = str[a];
        str[a]=str[b];
        str[b]=temp;
    }

    public static void main(String[] args) {
        System.out.println(generatePerm("abc"));
    }
}
