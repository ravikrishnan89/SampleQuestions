/**
 * Created by ravi.krishnan on 31/10/16.
 */
public class LongestPath {


    boolean visited[][];
    int arr[][];
    int rsize, csize;
    int maxLength=0;


    public void traversePath( int i , int j, int length, int desti, int destj){
        if(i>=rsize || i<0 || j>=csize || j<0 || visited[i][j] || arr[i][j]==0)
            return;
        if(i== desti && j==destj){
            if(length>maxLength)
                maxLength = length;
            return;
        }
        visited[i][j] = true;
        traversePath(i+1,j, length +1, desti, destj);
        traversePath(i-1,j, length +1, desti, destj);
        traversePath(i,j+1, length +1, desti, destj);
        traversePath(i,j-1, length +1, desti, destj);
        visited[i][j] = false;
        return ;
    }
    public int findlongestPath( int desti , int destj){
        rsize = arr.length;
        csize = arr[0].length;
        traversePath(0,0,0,desti,destj);
        return maxLength;
    }

    public static void main(String[] args) {

        int  [][] mat =
        {
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 0, 1, 1, 0, 1, 1, 0, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
        };
        LongestPath longestPath = new LongestPath();
        longestPath.visited = new boolean[mat.length][mat[0].length];
        longestPath.arr = mat;
        System.out.println(longestPath.findlongestPath(1,7));
    }
}
