import java.util.*;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * Created by ravi.krishnan on 16/03/17.
 */
public class LastWord {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t=0;t<test;t++){
            String input = sc.next();
            int count = t +1;
            System.out.println("Case #" + count + ": " + getMaxString(input.toCharArray()));
        }
    }

    static String getMaxString(char[] input){
        int n = input.length;
        java.util.LinkedList<Character> linkedList = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(linkedList.isEmpty()){
                linkedList.addLast(input[i]);
            }else if(input[i]<linkedList.getFirst()){
                linkedList.addLast(input[i]);
            }else {
                linkedList.addFirst(input[i]);
            }
        }
        return linkedList.stream()
                .map(c->c.toString()).collect(Collectors.joining());
    }
}
