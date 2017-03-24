import java.util.*;
import java.util.LinkedList;

/**
 * Created by ravi.krishnan on 25/11/16.
 */
public class Share {

    static List<List<Integer>> sequences= new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=0;t<T;t++){
            long profit = 0;
            int n = sc.nextInt();
            int [] input = new int[n];
            for(int i=0;i<n;i++){
                input[i] = sc.nextInt();
            }
            sequences.clear();
            List<Integer> sequenceList = new LinkedList<>();
            sequenceList.add(input[0]);
            sequences.add(sequenceList);
            for(int i=1;i<n;i++){
                boolean increasingFound = false;
                for(List<Integer> increasingList:sequences){
                    if(input[i]>increasingList.get(increasingList.size()-1)){
                        increasingList.add(input[i]);
                        increasingFound = true;
                    }
                }
                if(!increasingFound){
                    List<Integer> newList = new LinkedList<>();
                    newList.add(input[i]);
                    sequences.add(newList);
                }
            }
            for(List<Integer> increasingList: sequences){
                long sum = 0;
                for(Integer number: increasingList){
                    sum+= number;
                }
                profit+=increasingList.get(increasingList.size() -1) *increasingList.size() - sum;
            }
            System.out.println(profit);
        }
    }
}
