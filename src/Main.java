import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static boolean [] visit;
    public static List<Integer>[] adjacencyMatrix;
    public static List<Integer>[] reachable;

    public static void bfs(int n, int comp){
       if(visit[n])
           return;
        visit[n] = true;
        if(reachable[comp] == null){
            reachable[comp] = new ArrayList<>();
        }
        reachable[comp].add(n);
        for(int i: adjacencyMatrix[n]) {
            bfs(i,comp);
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        adjacencyMatrix = new List[n+1];
        visit = new boolean[n+1];
        for(int i=0;i<n;i++){
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            if(adjacencyMatrix[u] == null){
                adjacencyMatrix[u] = new ArrayList<>();
            }
            if(adjacencyMatrix[v] == null){
                adjacencyMatrix[v] = new ArrayList<>();
            }
            adjacencyMatrix[u].add(v);
            adjacencyMatrix[v].add(u);
        }
        int comp = 0;
        reachable = new List[n];
        for(int i=1;i<=n;i++){
            if(!visit[i]){
                bfs(i,comp);
                comp ++;
            }
        }
        for(int i=0;i<comp;i++){
            for(int j :reachable[i]){
                System.out.print(j + ",");
            }
            System.out.println();
        }
    }
}
