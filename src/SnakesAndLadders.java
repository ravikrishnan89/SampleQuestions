/**
 * Created by ravi.krishnan on 26/01/17.
 */
import java.util.*;
import java.util.LinkedList;


public class SnakesAndLadders {

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int test = scanner.nextInt();
        for(int t=0;t<test;t++){
            int l = scanner.nextInt();
            Map<Integer, Set<Integer>> map = new HashMap();
            for(int i=0;i<l;i++){
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                if(map.containsKey(start)){
                    map.get(start).add(end);
                }else{
                    Set<Integer> destSet = new HashSet();
                    destSet.add(end);
                    map.put(start,destSet);
                }
            }
            int s = scanner.nextInt();
            Map<Integer,Set<Integer>> snakes = new HashMap();
            for(int i=0;i<s;i++){
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                if(map.containsKey(start)){
                    map.get(start).add(end);
                }else{
                    Set<Integer> destSet = new HashSet();
                    destSet.add(end);
                    map.put(start,destSet);
                }
            }
            System.out.println(calculateMinSteps(map,snakes,100));
        }
    }

    public static int calculateMinSteps(Map<Integer,Set<Integer>> ladder, Map<Integer,Set<Integer>> snakes, int n){
        int [] minSteps = new int[n+1];
        for(int i=1;i<=n;i++){
            minSteps[i] = Integer.MAX_VALUE;
        }
        boolean [] traversed = new boolean[n+1];
        for(int i=0;i<=n;i++){
            traversed[i] = false;
        }
        int total = bfs(1,n , ladder,minSteps);
        if(total!=Integer.MAX_VALUE){
            return total;
        }
        return -1;
        /*minSteps[0] = 0;
        for(int i=1;i<=n;i++){
            if(minSteps[i]==-1)
                continue;
            for(int die = 1;die<=6;die++){
                minSteps[i] = i-die>=0 && minSteps[i-die]!=-1?Math.min(minSteps[i],minSteps[i-die] + 1):minSteps[i];
            }
            Set<Integer> ladderSet = ladder.get(i);
            if(ladderSet!=null){
                Iterator ladderIterator = ladderSet.iterator();
                while(ladderIterator.hasNext()){
                    minSteps[i]= Math.min(minSteps[i],minSteps[((Integer)ladderIterator.next())]);
                }
            }
        }
        if(minSteps[n]!=Integer.MAX_VALUE){
            return minSteps[n];
        }*/
    }

    public static int dfs(int n, Map<Integer,Set<Integer>> ladder, Map<Integer,Set<Integer>> snakes, int [] minSteps, boolean [] traversed) {
        traversed[n] = true;
        for (int die = 1; die <= 6; die++) {
            if (n - die >= 0 && !traversed[n - die]) {
                minSteps[n] = Math.min(minSteps[n], dfs(n-die,ladder,snakes,minSteps,traversed) + 1);
            }
        }
        if (ladder.containsKey(n)) {
            ladder.get(n).forEach(src -> {
                if (!traversed[src])
                    Math.min(minSteps[n], dfs(src, ladder, snakes, minSteps, traversed));
            });
        }
        if (snakes.containsKey(n)) {
            snakes.get(n).forEach(src -> {
                if (!traversed[src])
                    Math.min(minSteps[n], dfs(src, ladder, snakes, minSteps, traversed));
            });
        }
        traversed[n] = false;
        return minSteps[n];
    }


    public static boolean hasASnake(Map<Integer,Set<Integer>> ladder, int curr){
        return ladder.get(curr) != null && ladder.get(curr).stream().filter(n->n<curr).count()>0;
    }
    public static int bfs(int start, int end, Map<Integer,Set<Integer>> ladder, int [] minSteps) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(start);
        minSteps[start] = 0;
        for(int i=2;i<=end;i++){
            minSteps[i] = Integer.MAX_VALUE;
        }
        while(!queue.isEmpty()){
            int curr = queue.poll();
            for(int die = 1;die<=6;die++){
                if(curr+ die<=end && minSteps[curr + die]> minSteps[curr] + 1 &&
                        (!hasASnake(ladder,curr))) {
                    minSteps[curr + die] = minSteps[curr] + 1;
                    queue.add(curr + die);
                }
            }
            if (ladder.containsKey(curr)) {
                ladder.get(curr).forEach(dest -> {
                    if (minSteps[dest]> minSteps[curr]) {
                        minSteps[dest]=minSteps[curr];
                        queue.add(dest);
                    }
                });
            }
        }
        return minSteps[end];
    }
}
