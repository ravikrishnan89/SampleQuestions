import java.util.ArrayList;
import java.util.List;

/**
 * Created by ravi.krishnan on 14/01/17.
 */
public class UglyNumber {

    public static int findNthUgly(int [] primes, int n){
        int [] uglyArray = new int[n];
        int [] primeIndexArray = new int[primes.length];
        for(int i=0;i<primes.length;i++){
            primeIndexArray[0]=0;
        }
        int currentIndex = 0;
        uglyArray[currentIndex] = 1;
        currentIndex++;
        while(currentIndex<n){
            int min = Integer.MAX_VALUE;
            List<Integer> minIndexList = new ArrayList<>();
            for(int i=0;i<primes.length;i++){
                int curr = uglyArray[primeIndexArray[i]] * primes[i];
                if(curr == min){
                    min = curr;
                    minIndexList.add(i);
                }
                else if(curr<min){
                    min = curr;
                    minIndexList.clear();
                    minIndexList.add(i);
                }
            }
            for(int j=0;j<minIndexList.size();j++){
                primeIndexArray[minIndexList.get(j)]++;
            }
            uglyArray[currentIndex++] = min;
        }
        return uglyArray[currentIndex-1];
    }
    public static void main(String[] args) {
        int [] primes = {3, 5, 7, 11, 13};
        System.out.println(findNthUgly(primes,9));
    }
}
