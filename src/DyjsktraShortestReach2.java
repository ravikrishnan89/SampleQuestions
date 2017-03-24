import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.LinkedList;

/**
 * Created by ravi.krishnan on 12/02/17.
 */
public class DyjsktraShortestReach2 {

    static Set[] sets;
    static class Node {
        int n1,n2,weight;

        public Node(int n1, int n2, int weight) {
            this.n1 = n1;
            this.n2 = n2;
            this.weight = weight;
        }
    }

    static int[][] edges;
    static void buildPath(Set[] nodeLists,Integer start){
        int [] dist = new int [nodeLists.length];
        for(int i=1;i<nodeLists.length;i++){
            dist[i] = -1;
        }
        dist[start] = 0;
        Queue<Integer> nodeQueue = new LinkedList<Integer>();
        nodeQueue.add(start);
        while(!nodeQueue.isEmpty()){
            int startnode = nodeQueue.poll();
            sets[startnode].forEach(node->{
                int next = (Integer)node;
                int weight = edges[startnode][next];
                int currentDist = dist[startnode] + weight;
                if((dist[next]==-1) || (dist[next]>currentDist)){
                    dist[next] = currentDist;
                    nodeQueue.add(next);
                }
            });
        }
        for(int i=1;i<nodeLists.length;i++){
            if(i == start) {
                continue;
            }
            System.out.print(dist[i] + " ");
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));
        //Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(inp.readLine());//sc.nextInt();
        for(int t=0;t<test;t++){
            /*int N = sc.nextInt();
            int M = sc.nextInt();*/
            String [] intValues = inp.readLine().split(" ");
            int N = Integer.parseInt(intValues[0]);
            int M = Integer.parseInt(intValues[1]);
            sets = new Set[N+1];
            edges = new int[N+1][N+1];
            for(int i=0;i<M;i++){

                /*int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                int weight = sc.nextInt();*/
                String [] nodeValues = inp.readLine().split(" ");
                int n1 = Integer.parseInt(nodeValues[0]);
                int n2 = Integer.parseInt(nodeValues[1]);
                int weight = Integer.parseInt(nodeValues[2]);
                Node node  = new Node(n1,n2,weight);
                if(sets[n1] == null){
                    sets[n1] = new HashSet<>();
                }if(sets[n2] == null){
                    sets[n2] = new HashSet<>();
                }
                if(edges[n1][n2]==0 || edges[n1][n2]>weight){
                    edges[n1][n2] = weight;
                    edges[n2][n1] = weight;
                    sets[n1].add(n2);
                    sets[n2].add(n1);
                }
            }
            //int start = sc.nextInt();
            int start = Integer.parseInt(inp.readLine());
            buildPath(sets,start);
            System.out.println();
        }
    }
}
