/**
 * Created by ravi.krishnan on 03/01/17.
 */
public class MinimumCutPalindrome {


    static boolean [] [] a;
    public static void buildPalindromeArray(String str){
        int n = str.length();
        a = new boolean [n+1][n+1];
        for(int i=0;i<n;i++){
            a[i][0] = true;
        }
        char [] charArray = str.toCharArray();
        for(int i=1;i<charArray.length;i++){
            int j=i+1;
            int k=i-1;
            while(j<=charArray.length && k>=0){
                if(j<charArray.length) {
                    if (charArray[j] == charArray[k] &&
                            a[j-1][j-k -2]) {
                        a[k][j - k + 1] = true;
                    } else {
                        a[k][j - k + 1] = false;
                    }
                }
                if(charArray[j-1] == charArray[k]
                        &&
                        a[j-2][j-k-3]){
                    a[k][j-k-1] = true;
                }else{
                    a[k][j-k-1] = false;
                }
                j++;
                k--;
            }
        }

    }
    public void minimumCuts(String str){

    }
    public static void main(String[] args) {
        String str = "adsasda";
        buildPalindromeArray(str);
        System.out.println();
    }
}
