/**
 * Created by ravi.krishnan on 11/11/16.
 */
public class StackWithMiddle {
    private class Node{
        Node next;
        Node previous;
        int data;
    }

    Node current, middle;
    int count =0;


    void push(int data){
        Node newNode = new Node();
        newNode.data = data;
        if(current == null){
            current = middle = newNode;
        }else{
            current.next = newNode;
            newNode.previous=current;
            if(count%2==0){
                middle = middle.next;
            }
            current = current.next;
        }
        count ++;
    }

     int pop() throws Exception {
         if(count>0) {
             int data = current.data;
             if (count == 1) {
                 current = middle = null;
                 count--;
                 return data;
             } else {
                 Node temp = current;
                 current = current.previous;
                 temp.previous = null;
                 current.next = null;
             }
             if (count % 2 == 1) {
                 middle = middle.previous;
             }
             count--;
             return data;
         }
         throw new Exception("Underflow");
    }

    public void deleteMiddleElement() throws Exception {
        if(count == 0){
            throw new Exception("Underflow");
        }
        if(count>1) {
            Node temp = middle;
            if(count%2 ==0) {
                middle = middle.next;
            }else{
                middle = middle.previous;
            }
            if(temp.previous!=null) {
                temp.previous.next = temp.next;
            }
            if(temp.next!=null) {
                temp.next.previous = temp.previous;
            }
            temp.previous = null;
            temp.next = null;
        }else{
            current = middle = null;
        }
        count --;
    }

    public int getMiddleElement() throws Exception {
        if(count ==0){
            throw new Exception("No element");
        }
        return middle.data;
    }

    public static void main(String[] args) {
        StackWithMiddle stackWithMiddle = new StackWithMiddle();

        System.out.println(stackWithMiddle);
    }
}
