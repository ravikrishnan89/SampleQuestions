import java.util.*;

import static sun.swing.MenuItemLayoutHelper.max;

/**
 * Created by ravi.krishnan on 10/11/16.
 */


public class BuildingBridges {
    static List<Pair> pairs = new ArrayList<Pair>();
    static int[] longestIncreasing;
    private static class Pair{
        int a,b;
    }

    private static class PairComparator implements Comparator<Pair>{
        @Override
        public int compare(Pair o1, Pair o2) {
            return o1.a - o2.a;
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i=0;i<n;i++) {
            Pair p = new Pair();
            p.a = scanner.nextInt();
            p.b = scanner.nextInt();
            pairs.add(p);
        }
        longestIncreasing = new int[pairs.size()];
        Collections.sort(pairs,new PairComparator());
        System.out.println(longestIncreasingSubsequence());

    }


    public static int longestIncreasingSubsequence(){
        for(int i=0;i<pairs.size();i++){
            longestIncreasing[i]=1;
        }
        for(int i=1;i<pairs.size();i++){
            for(int j=0;j<i;j++){
                if(pairs.get(i).b>pairs.get(j).b){
                    longestIncreasing[i] = max(longestIncreasing[i],longestIncreasing[j] + 1);
                }
            }
        }
        return longestIncreasing[pairs.size()-1];

    }
}
