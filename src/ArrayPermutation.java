import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ravi.krishnan on 14/01/17.
 */
public class ArrayPermutation {
    public static void listOutput(List<List<Integer>> inputList, int outerIndex,
                                  List<List<Integer>> outputList, int outputInnerIndex,
                                  List<Integer> tempList){
        if(outerIndex>=inputList.size()) {
            outputList.add(new ArrayList<Integer>(tempList));
            return;
        }
        for(int i=0;i<inputList.get(outerIndex).size();i++){
            tempList.set(outputInnerIndex,inputList.get(outerIndex).get(i));
            listOutput(inputList,outerIndex+1,outputList, outputInnerIndex +1, tempList);
        }
    }

    public static List<List<Integer>> getOutputList(List<List<Integer>> inputList){
        List<List<Integer>> outputList = new ArrayList<List<Integer>>();
        listOutput(inputList,0, outputList, 0, Arrays.asList(new Integer[inputList.size()]));
        return outputList;
    }
    public static void main(String[] args) {
        List<List<Integer>> inputList = new ArrayList<List<Integer>>();
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for(int i=0;i<n;i++){
            List<Integer> inner = new ArrayList<Integer>();
            String input = scanner.nextLine();
            String [] strings = input.split(" ");
            for(int j=0;j<strings.length;j++){
                inner.add(Integer.parseInt(strings[j]));
            }
            inputList.add(inner);
        }
        List<List<Integer>> outputList = getOutputList(inputList);
        System.out.println(outputList);
        System.out.println(outputList.size());
    }
}
