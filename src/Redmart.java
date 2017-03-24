import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ravi.krishnan on 17/01/17.
 */
public class Redmart {

    static List<Integer> [][] lists;
    static List<Integer> buildList(int [] [] arr, int m, int n, int currRow, int currCol){
        List<Integer> currList = new ArrayList<>();
        if(currRow<0|| currCol<0|| currRow>=m || currCol>=n ){
            return currList;
        }
        if(lists[currRow][currCol]!=null){
            return lists[currRow][currCol];
        }else {
            currList.add(arr[currRow][currCol]);
            List<Integer> maxList = null;
            if (currRow > 0 && arr[currRow - 1][currCol] < arr[currRow][currCol]) {
                maxList = buildList(arr, m, n, currRow - 1, currCol);
            }
            if (currCol > 0 && arr[currRow][currCol - 1] < arr[currRow][currCol]) {
                maxList = getGreaterList(maxList, buildList(arr, m, n, currRow, currCol - 1));
            }
            if (currRow < m - 1 && arr[currRow + 1][currCol] < arr[currRow][currCol]) {
                maxList = getGreaterList(maxList, buildList(arr, m, n, currRow + 1, currCol));
            }
            if (currCol < n - 1 && arr[currRow][currCol + 1] < arr[currRow][currCol]) {
                maxList = getGreaterList(maxList, buildList(arr, m, n, currRow, currCol + 1));
            }
            if (maxList != null) {
                currList.addAll(maxList);
            }
            lists[currRow][currCol] = currList;
            return lists[currRow][currCol];
        }
    }

    static List<Integer> getGreaterList(List<Integer> listA, List<Integer> listB){
        if(listA == null)
            return listB;
        if(listA.size()>listB.size()){
            return listA;
        }else if(listB.size()>listA.size()) {
            return listB;
        }
        if ((listA.get(0) - listA.get(listA.size() - 1)) >
                (listB.get(0) - listB.get(listB.size() - 1)) && !listA.isEmpty()) {
            return listA;
        }
        return listB;
    }
    static List<Integer> getMaxList(int [][] arr, int m, int n) {
        List<Integer> maxList = null;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                maxList = getGreaterList(maxList,buildList(arr, m, n, i, j));
            }
        }
        return maxList;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        lists = new List[m][n];
        int [][] arr = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = scanner.nextInt();
            }
        }
        List<Integer> maxList = getMaxList(arr,m,n);
        System.out.println(maxList.size() + " " + (maxList.get(0) - maxList.get(maxList.size()-1)));
    }
}
