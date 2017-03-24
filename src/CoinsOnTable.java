import java.util.Scanner;

/**
 * Created by ravi.krishnan on 26/11/16.
 */
public class CoinsOnTable {
    static char [] [] arr ;
    static int time;
    static int n;
    static int m;
    static int minChanges =-1;
    static int maxvalue = 7000;
    static int [] [] [] minChangesArray ;
    static boolean [] [] path ;

    private static int calculateMinimumChanges(int r,int c, int t){
        if(t>time){
            return maxvalue;
        }
        if(r>=n || c>=m ){
            return maxvalue;
        }
        if(arr[r][c] == '*'){
            minChangesArray[r][c][t] =0;
            return 0;
            /*if(changes<minChanges){
                minChanges = changes;
            }*/
        }
        else{
            if(minChangesArray[r][c][t]!= -1){
                if(minChangesArray[r][c][t]!= 7000){
                    int a = 1;
                }
                return minChangesArray[r][c][t];
            }
            path[r][c] = true;
            int changes = maxvalue;
            if(arr[r][c] == 'R'){
                if(c+1<m && !path[r][c+1]) {
                    int changesNext = calculateMinimumChanges(r, c + 1, t + 1);
                    changes = Math.min(changes,changesNext);
                }
                //Change to L
                if(c-1>-1 &&!path[r][c-1]) {
                    int changesNext = calculateMinimumChanges(r,c-1,t+1);
                    if(changesNext!=-1) {
                        if(changes!=-1)
                            changes = Math.min(changes, changesNext + 1);
                        else
                            changes = changesNext +1;
                    }else{
                        changes = changesNext;
                    }
                }
                //Change to U
                if(r-1>-1 &&!path[r-1][c]){
                    int changesNext = calculateMinimumChanges(r-1,c,t+1);
                    if(changesNext!=-1) {
                        if(changes!=-1)
                        changes = Math.min(changes, changesNext + 1);
                        else
                        changes = changesNext +1;
                    }else{
                        changes = changesNext;
                    }
                }
                //Change to D
                if(r+1<n && !path[r+1][c]) {
                    int changesNext = calculateMinimumChanges(r + 1, c, t + 1);
                    if(changesNext!=-1){
                        if(changes!=-1)
                            changes = Math.min(changes, changesNext + 1);
                        else
                            changes = changesNext +1;
                    }else {
                        changes = changesNext;
                    }
                }
            }else if(arr[r][c] == 'L') {
                if(c-1>-1 && !path[r][c-1]) {
                    changes = Math.min(changes,calculateMinimumChanges(r,c-1,t+1));
                }
                //Change to R
                if(c+1<m && !path[r][c+1]) {
                    int changesNext = calculateMinimumChanges(r, c + 1, t + 1);
                    if(changesNext!=-1) {
                        if(changes!=-1)
                            changes = Math.min(changes, changesNext + 1);
                        else
                            changes = changesNext +1;
                    }else{
                        changes = changesNext;
                    }
                }
                //Change to U
                if(r-1>-1 &&!path[r-1][c]){
                    int changesNext = calculateMinimumChanges(r-1,c,t+1);
                    if(changesNext!=-1) {
                        if(changes!=-1)
                            changes = Math.min(changes, changesNext + 1);
                        else
                            changes = changesNext +1;
                    }
                    else {
                        changes = changesNext;
                    }

                }
                //Change to D
                if(r+1<n &&!path[r+1][c]) {
                    int changesNext = calculateMinimumChanges(r + 1, c, t + 1);
                    if(changesNext!=-1) {
                        if(changes!=-1)
                            changes = Math.min(changes, changesNext + 1);
                        else
                            changes = changesNext +1;
                    }
                    else {
                        changes = changesNext;
                    }
                }
            }else if(arr[r][c] == 'D') {
                if(r+1<n &&!path[r+1][c]) {
                    changes = Math.min(changes,calculateMinimumChanges(r + 1, c, t + 1)) ;
                }
                //Change to L
                if(c-1>-1 &&!path[r][c-1]) {
                    int changesNext = calculateMinimumChanges(r,c-1,t+1);
                    if(changesNext!=-1) {
                        if(changes!=-1)
                            changes = Math.min(changes, changesNext + 1);
                        else
                            changes = changesNext +1;
                    }
                    else {
                        changes = changesNext;
                    }
                }
                //Change to R
                if(c+1<m &&!path[r][c+1]) {
                    int changesNext = calculateMinimumChanges(r, c + 1, t + 1);
                    if(changesNext!=-1) {
                        if(changes!=-1)
                            changes = Math.min(changes, changesNext + 1);
                        else
                            changes = changesNext +1;
                    }
                    else {
                        changes = changesNext;
                    }
                }
                //Change to U
                if(r-1>-1 &&!path[r-1][c]){
                    int changesNext = calculateMinimumChanges(r-1,c,t+1);
                    if(changesNext!=-1) {
                        if(changes!=-1)
                            changes = Math.min(changes, changesNext + 1);
                        else
                            changes = changesNext +1;
                    }
                    else {
                        changes = changesNext;
                    }
                }
            }else if(arr[r][c] == 'U'){
                if(r-1>-1 &&!path[r-1][c]){
                    changes = Math.min(changes,calculateMinimumChanges(r-1,c,t+1));
                }
                //Change to D
                if(r+1<n &&!path[r+1][c]) {
                    int changesNext = calculateMinimumChanges(r + 1, c, t + 1);
                    if(changesNext!=-1) {
                        if(changes!=-1)
                            changes = Math.min(changes, changesNext + 1);
                        else
                            changes = changesNext +1;
                    }
                    else {
                        changes = changesNext;
                    }
                }
                //Change to L
                if(c-1>-1 &&!path[r][c-1]) {
                    int changesNext = calculateMinimumChanges(r,c-1,t+1);
                    if(changesNext!=-1) {
                        if(changes!=-1)
                            changes = Math.min(changes, changesNext + 1);
                        else
                            changes = changesNext +1;
                    }
                    else {
                        changes = changesNext;
                    }
                }
                //Change to R
                if(c+1<m &&!path[r][c+1]) {
                    int changesNext = calculateMinimumChanges(r, c + 1, t + 1);
                    if(changesNext!=-1) {
                        if(changes!=-1)
                            changes = Math.min(changes, changesNext + 1);
                        else
                            changes = changesNext +1;
                    }
                    else {
                        changes = changesNext;
                    }
                }
            }
            minChangesArray[r][c][t] =changes;
            path[r][c] = false;
            return minChangesArray[r][c][t] ;
        }
    }




    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        arr = new char[n][m];
        path = new boolean[n][m];
        int t = scanner.nextInt();
        minChangesArray = new int[n][m][t + 1];
        time = t;
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String chars = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = chars.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k <= t; k++) {
                    minChangesArray[i][j][k] = -1;
                }
            }
        }
            int changes = calculateMinimumChanges(0, 0, 0);
            if (changes != maxvalue)
                System.out.println(changes);
            else
                System.out.println(-1);


    }
}
