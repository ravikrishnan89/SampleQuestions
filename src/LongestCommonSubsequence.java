import static sun.swing.MenuItemLayoutHelper.max;

/**
 * Created by ravi.krishnan on 24/11/16.
 */
public class LongestCommonSubsequence {

    private int findlcs(int arr1[], int arr2[]){
        int m = arr1.length;
        int n= arr2.length;
        int table[][] = new int[m][n];
        for(int i=0;i<m;i++){
            table[i][0] = arr1[i] == arr2[0] ?1:0;
        }
        for(int i=0;i<n;i++){
            table[0][i] = arr1[0] == arr2[i] ?1:0;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(arr1[i] == arr2[j]){
                    table[i][j] = table[i-1][j-1] + 1;
                }else{
                    table[i][j] = max(table[i-1][j], table[i][j-1]);
                }
            }
        }
        return table[m-1][n-1];
    }

    private int findlcsubset(int arr1[], int arr2[]){
        int m = arr1.length;
        int n= arr2.length;
        int longestSubset = Integer.MIN_VALUE;
        int table[][] = new int[m][n];
        for(int i=0;i<m;i++){
            table[i][0] = arr1[i] == arr2[0] ?1:0;
        }
        for(int i=0;i<n;i++){
            table[0][i] = arr1[0] == arr2[i] ?1:0;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(arr1[i] == arr2[j]){
                    table[i][j] = table[i-1][j-1] + 1;
                }else{
                    table[i][j] = 0;
                }
                longestSubset = Integer.max(longestSubset, table[i][j]);
            }
        }
        return longestSubset;
    }

    public static void main(String[] args) {
        int []arr1 = {1,2,3,4,5,7,9,8,10,17,15,20};
        int [] arr2 = {2,3,4,9,10,15,20};
        System.out.println(new LongestCommonSubsequence().findlcsubset(arr1,arr2));
    }
}
