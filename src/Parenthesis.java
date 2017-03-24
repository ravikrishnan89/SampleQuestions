import java.util.Scanner;
import java.util.Stack;

/**
 * Created by ravi.krishnan on 11/11/16.
 */
public class Parenthesis {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s =scanner.nextLine();
        System.out.println(maximumBalancedLength(s));
    }

    public static int maximumBalancedLength(String s) {
        int maxLength = 0;
        Stack<Integer> stack = new Stack<>();
        char[] chars = s.toCharArray();
        stack.push(-1);
        for(int i=0;i<chars.length;i++){
            if(chars[i] == '('){
                stack.push(i);
            }else{
                int front = stack.peek();
                if(front!=-1 && chars[front] == '('){
                    stack.pop();
                }
                int currlength = i - stack.peek();
                if(currlength>maxLength){
                    maxLength = currlength;
                }
            }
        }
        return maxLength;
    }
}
