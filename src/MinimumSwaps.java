import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by ravi.krishnan on 13/02/17.
 */
public class MinimumSwaps {

    public class SwappedIndex{
        int swappedFrom;
        int swappedTo;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof SwappedIndex)) return false;

            SwappedIndex that = (SwappedIndex) o;

            if (swappedFrom != that.swappedFrom) return false;
            return swappedTo == that.swappedTo;

        }

        @Override
        public int hashCode() {
            int result = swappedFrom;
            result = 31 * result + swappedTo;
            return result;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        long [] arr = new long[N+1];
        long [] sortedArr = new long[N+1];
        Map<Long,Integer> oldIndexMap = new HashMap<>();
        Map<Long,Integer> newIndexMap = new HashMap<>();
        for(int i=0;i<N;i++){
            arr[i] = scanner.nextLong();
            sortedArr[i] =scanner.nextLong();
            oldIndexMap.put(arr[i],i);
        }
        Arrays.sort(sortedArr);
        for(int i=0;i<arr.length;i++){

        }
    }
}
