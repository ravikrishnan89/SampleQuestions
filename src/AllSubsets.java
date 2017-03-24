import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ravi.krishnan on 24/01/17.
 */
public class AllSubsets {

    static boolean [][] found;
    static List<List<Integer>> findAllSubsets(List<Integer> inputList){
        List<List<Integer>> outputList = new LinkedList<>();
        found = new boolean[inputList.size()][inputList.size()];
        findAllSubsets(inputList,outputList, 0, inputList.size() -1);
        return  outputList;
    }


    static void findAllSubsets(List<Integer> inputList, List<List<Integer>> subsets, int start, int end){
            int num = (int)Math.pow(2,inputList.size()) - 1;
            while(num>0){
                List<Integer> subset = new ArrayList();
                for(int i=0;i<inputList.size();i++){
                    if((num>>i&1)==1){
                        subset.add(inputList.get(i));
                    }
                }
                num-=1;
                subsets.add(subset);
            }
    }




    public static void main(String[] args) {
        Integer [] array = {1,2,3,4};
        System.out.println(findAllSubsets((List<Integer>) Arrays.asList(array)));
    }
}
