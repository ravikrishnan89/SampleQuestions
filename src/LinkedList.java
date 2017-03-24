/**
 * Created by ravi.krishnan on 29/10/16.
 */
public class LinkedList<T> {

    private class Node{
        T data;
        Node next;
        Node previous;
    }

    Node head, tail;
    int size;

    public LinkedList(){

    }
    public void add(T data){
        Node temp = new Node();
        temp.data = data;
        temp.next=null;
        if(head == null){
            tail = head = temp;
        }else{
            temp.previous = tail;
            tail.next = temp;
            tail = tail.next;
        }
        size ++;
    }


    public void deleteLastElement(){
        if(size == 0){
            System.out.println("Nothing to delete");
            return;
        }
        if(head == tail) {
            head = tail = null;
        }
        else{
            Node toDelete = tail;
            tail = tail.previous;
            tail.next = null;
            toDelete.previous = null;
        }
        size --;
    }


    public T getLastElement() throws Exception {
        if(tail == null){
            throw new Exception("Stack is Empty");
        }
        return tail.data;
    }

    public void display() {
        Node temp;
        if (head != null){
            for (temp = head; temp != tail; temp = temp.next) {
                System.out.println(temp.data);
            }
        System.out.println(temp.data);
        }
    }
}
