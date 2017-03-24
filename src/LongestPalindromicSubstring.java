/**
 * Created by ravi.krishnan on 15/01/17.
 */
public class LongestPalindromicSubstring {

    public static void printLongestSubstring(String str){
        char [] chars = str.toCharArray();
        int maxLength = Integer.MIN_VALUE;
        int start=0,end=0;
        for(int i=1;i<chars.length;i++){
            int high =i+1;
            int low = i;
            while(low>-1 && high<chars.length && chars[low] == chars[high]){
                if(high - low + 1 > maxLength){
                    maxLength = high -low +1;
                    start = low;
                    end = high;
                }
                low--;
                high++;
            }
            high =i+1;
            low = i-1;
            while(low>-1 && high<chars.length && chars[low] == chars[high]){
                if(high - low + 1 > maxLength){
                    maxLength = high -low +1;
                    start = low;
                    end = high;
                }
                low--;
                high++;
            }
        }

        System.out.println(str.substring(start,end +1));
    }

    public static void main(String[] args) {
        String str = "forgeeksskeegfor";
        printLongestSubstring(str);
    }
}
