/**
 * Created by ravi.krishnan on 18/02/17.
 */
public class CoinsPickingGame {

    Maximum [] [] maxima;
    public class Maximum{
        int curr;
        int prev;

        public Maximum(int curr, int prev) {
            this.curr = curr;
            this.prev = prev;
        }
    }
    public static void main(String[] args) {
        int [] arr = {8, 15, 3, 7};
        int max = new CoinsPickingGame().findMaximumAmount(arr);
        System.out.println(max);
    }


    int findMaximumAmount(int [] arr){
        maxima = new Maximum[arr.length][arr.length];
        findMax(arr,0,arr.length -1);
        return maxima[0][arr.length - 1].curr;
    }


    Maximum findMax(int [] arr, int start,int end){
        if(start>end){
            return new Maximum(0,0);
        }
        if(maxima[start][end]!=null){
            return maxima[start][end];
        }
        Maximum max1 = findMax(arr,start + 1 , end);
        Maximum max2 = findMax(arr,start , end - 1);
        int curr;
        int prev;
        if(max1.prev + arr[start]> max2.prev + arr[end]){
            curr = max1.prev + arr[start];
            prev = max1.curr;
        }
        else{
            curr = max2.prev + arr[end];
            prev = max2.curr;
        }
        maxima[start][end] = new Maximum(curr,prev);
        return maxima[start][end];
    }
}
