import java.util.Scanner;

class GFG {

    public static int findMaxProfit(int [] c){
        int n = c.length;
        int min = c[0];
        int maxProfit = Integer.MIN_VALUE;
        for(int i=1;i<n;i++){
            if(c[i]<min){
                c[i] = min;
            }
            else if(c[i] - min> maxProfit){
                maxProfit = c[i] - min;
            }
        }
        return maxProfit;
    }
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int t=0;t<T;t++){
            int n = scanner.nextInt();
            int [] c = new int[n];
            for(int i=0;i<n;i++){
                c[i] = scanner.nextInt();
            }
            System.out.println(findMaxProfit(c));
        }
    }
}