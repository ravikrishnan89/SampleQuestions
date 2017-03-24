/**
 * Created by ravi.krishnan on 29/10/16.
 */
public class Stack<T> {
    private LinkedList<T> linkedList = new LinkedList<>();

    public void push(T data){
        linkedList.add(data);
    }

    public T pop() throws Exception {
        T data = linkedList.getLastElement();
        linkedList.deleteLastElement();
        return data;
    }

    public void display(){
        linkedList.display();
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for(int i =0;i<10;i++) {
            stack.push(i);
            stack.push(i*2);
            stack.push(i*3);
            try {
                stack.pop();
                stack.pop();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        stack.display();
    }
}
