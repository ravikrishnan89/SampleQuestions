import java.util.Scanner;

/**
 * Created by ravi.krishnan on 15/03/17.
 */
public class MinPalindromeList {

    static boolean p[][];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            String input = sc.next();
            p = new boolean[input.length()][input.length()];
            findMinPalindromeCuts(input.toCharArray(), i+1);
        }
    }

    public static void findMinPalindromeCuts(char [] arr,int t){
        generatePalindromeSubStrings(arr);
        System.out.println("Case #" + t + ": " +findMaxCost(arr));
    }

    public static void generatePalindromeSubStrings(char [] arr){
        for (int i=0;i<arr.length;i++){
            int start = i;
            int end = i+1;
            while(start>=0 && end<arr.length){
                if(arr[start] == arr[end]){
                    p[start][end] = true;
                }else{
                    break;
                }
                start--;
                end++;
            }
        }
    }



    public static int findMaxCost(char [] arr){
        int [] mincutDp = new int[arr.length];
        int [] prev = new int[arr.length];
        for(int i=0;i<mincutDp.length;i++){
            mincutDp[i] = i;
            prev[i] = -2;
        }
        for(int i=1;i<arr.length;i++){
            for(int j=i-1;j>=0;j--){
                if(p[j][i]){
                    if(j>0 && mincutDp[j-1] + 1 <= mincutDp[i])
                        mincutDp[i] = mincutDp[j-1] + 1;
                    prev[i] = j -1;
                }
            }
        }
        int i = arr.length-1;
        int length = 0;
        if(prev[i]!=-2) {
            while (i >0) {
                if(prev[i]!=-2)
                    length += i - prev[i];
                i = prev[i];
            }
        }
        int totalCost = length/2 * 10 + (arr.length - length)/2 * 5;
        return totalCost;
    }
}
