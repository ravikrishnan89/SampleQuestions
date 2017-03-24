package Booking;

/**
 * Created by ravi.krishnan on 10/11/16.
 */
public class MaximumProduct {
    static int maxSubarrayProduct(int arr[]) {
        int n = arr.length;
        int maxProduct = 1;

        int minProduct = 1;


        int maxProductTillNow = 1;


        for (int i = 0; i < n; i++) {

            if (arr[i] > 0) {
                maxProduct = maxProduct * arr[i];
                minProduct = Math.min(minProduct * arr[i], 1);
            } else if (arr[i] == 0) {
                maxProduct = 1;
                minProduct = 1;
            } else {
                int temp = maxProduct;
                maxProduct = Math.max(minProduct * arr[i], 1);
                minProduct = temp * arr[i];
            }

            if (maxProductTillNow < maxProduct)
                maxProductTillNow = maxProduct;
        }

        return maxProductTillNow;
    }
}
