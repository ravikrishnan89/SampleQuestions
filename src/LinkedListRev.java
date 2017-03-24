/**
 * Created by ravi.krishnan on 11/11/16.
 */
public class LinkedListRev {

    private static class Node{
        public Node(int data) {
            this.data = data;
        }

        int data;
        Node next;
    }


    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(6);
        int count = 0;
        Node newHead = node;
        while(newHead.next!=null && count<3-1){
            newHead = newHead.next;
            count++;
        }
        Node reverseNode = node;
        while ((reverseNode =reverseKnode(reverseNode,3))!=null);
        System.out.println(node);
    }

    public static Node reverseKnode(Node root, int k){
        /*int count = 0;
        Node newHead = null;
        Node initialRoot = root;
        Node second = root.next;
        Node first = root;
        while(initialRoot!=null) {
            while (count < k-1) {
                if (second != null) {
                    Node temp = second.next;
                    second.next = first;
                    first = second;
                    second = temp;
                }
                count++;
            }
            if(newHead == null){
                newHead  = first;
            }
            initialRoot.next = second;
            count = 0;
        }
        return newHead;*/

        Node first = root;
        Node second = root.next;
        int count =1;
        while(count<k && second!=null){
            Node temp = second.next;
            second.next = first;
            first = second;
            second = temp;
            count ++;
        }
        root.next = second;
        return second;
    }
}
