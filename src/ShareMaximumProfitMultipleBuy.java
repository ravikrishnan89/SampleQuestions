import java.util.ArrayList;
import java.util.List;

/**
 * Created by ravi.krishnan on 26/11/16.
 */
public class ShareMaximumProfitMultipleBuy {

    private static class BuySell{
        int buy,sell;
    }
    public static void main(String[] args) {
        int [] a ={100, 180, 260, 90, 270, 50, 30, 20, 10,90};
        List<BuySell> buySellList = new ArrayList<>();
        int n = a.length;
        BuySell buySell = new BuySell();
        int currmin = a[0];
        buySell.buy = 0;
        int profit = 0;
        int i;
        for(i=1;i<n;i++){
            if(a[i]<a[i-1]){
                currmin = a[i];
                if(buySell.buy!=i-1) {
                    profit += a[i - 1] - currmin;
                    buySell.sell = i - 1;
                    buySellList.add(buySell);
                    buySell = new BuySell();
                }
                buySell.buy = i;
            }
        }
        if(a[i-1]>currmin){
            if(buySell.buy!=i-1) {
                buySell.sell = i - 1;
                buySellList.add(buySell);
                profit += a[i - 1] - currmin;
            }
        }
        System.out.println(profit);
        for(BuySell buySellElement: buySellList){
            System.out.println(buySellElement.buy + " " + buySellElement.sell);
        }
    }
}
