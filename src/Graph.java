import java.util.*;

/**
 * Created by ravi.krishnan on 04/11/16.
 */
public class Graph {

    public static Map<String,Set<String>> graph = new HashMap<>();
    public static Map<String, Boolean> traversed = new HashMap<>();

    public static boolean getDfsString(String node, StringBuilder currentString){
        if(Boolean.TRUE.equals(traversed.get(node))){
            return true;
        }
        currentString.append("(" + node);
        if(!graph.containsKey(node)) {
            currentString.append(")");
            return false;
        }
        traversed.put(node,true);
        Set<String> nodes = graph.get(node);
        Iterator nodesIterator = nodes.iterator();
        while(nodesIterator.hasNext()){
            if(getDfsString((String) nodesIterator.next(),currentString)){
                return true;
            }
        }
       /* boolean value = nodes.stream().forEach(n2->{
            if(getDfsString(n2,currentString))
                return true;
        });*/
        currentString.append(")");
        return false;
    }
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String [] tuples = string.split(" ");
        Set<String> node1Set = new HashSet<>();
        Set<String> node2Set = new HashSet<>();
        for(String tuple:tuples) {
            String n1 = tuple.substring(1, 2);
            String n2 = tuple.substring(3, 4);
            node1Set.add(n1);
            node1Set.add(n2);
            node2Set.add(n2);
            traversed.put(n1, false);
            traversed.put(n2, false);
            if (graph.containsKey(n1)) {
                Set<String> nodes = graph.get(n1);
                if (nodes.size() > 1) {
                    throw (new Exception("Number of children greater than 2 for node" + n1));
                } else if (nodes.contains(n2)) {
                    throw (new Exception("Tuple Already Exists" + n1));
                }else{
                    nodes.add(n2);
                }
            }else{
                Set<String> nodes = new LinkedHashSet<>();
                nodes.add(n2);
                graph.put(n1,nodes);
            }
        }
        node1Set.removeAll(node2Set);
        if(node1Set.size()>1){
            throw new Exception("multiple roots");
        }
        StringBuilder stringBuilder = new StringBuilder();
        if(getDfsString(node1Set.iterator().next(),stringBuilder)){
            throw new Exception("Cycle sets");
        }
        System.out.println(stringBuilder);
    }
}
