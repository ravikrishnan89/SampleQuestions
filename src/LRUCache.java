/*
import java.util.HashMap;
import java.util.Map;


*/
/**
 * Created by ravi.krishnan on 19/02/17.
 *//*

public class LRUCache {


    Node head,tail;
    Map<Integer, Node> cacheMap = new HashMap<Integer, Node>();
    Map<Integer, DLL> freqNodeListMap = new HashMap<Integer, DLL>();
    int capacity;
    class Node {
        int key, value, freq;
        Node next,prev;
    }

    private class DLL{
        Node head,tail;
        int count;

        public void addToList(Node node){
            if(head == null){
                tail = head = node;
            }else{
                node.next=head;
                head.prev=node;
                head = node;
            }
            count++;
        }


        public void deleteNode(Node node){
            if(head == tail){
                head=tail=null;
                count =0;
                return;
            }
            if(node.prev!=null){
                node.prev.next = node.next;
            }
            if(node.next!=null){
                node.next.prev = node.prev;
            }
            if(node == head){
                head= head.next;
            }
            if(node == tail){
                tail=tail.prev;
            }
            node.next=null;
            node.prev=null;
            count--;
        }
        public boolean isEmpty(){
            return count == 0;
        }
    }
    */
/*private void addToList(Node node){
        if(head == null){
            tail = head = node;
        }else{
            tail.next = node;
            node.prev=tail;
            tail=tail.next;
        }
    }*//*


    private void adjustListForGet(Node node){
        DLL list1 = freqNodeListMap.get(node.freq);
        list1.deleteNode(node);
        if(list1.isEmpty()){
            freqNodeListMap.remove(node.freq);
        }
        node.freq++;
        if(!freqNodeListMap.containsKey(node.freq)){
            DLL list2 = new DLL();
            list2.addToList(node);
        }
       */
/* if(node.prev!=null && node.prev.freq<=node.freq){
            node.prev.next = node.next;
            if(node.next!=null)
                node.next.prev = node.prev;
            node.next = node.prev;
            node.prev = node.prev.prev;
            if(node.prev!=null){
                node.prev.next = node;
            }
            node.next.prev = node;
            if(node == tail){
                tail=tail.next;
            }
        }*//*

    }

    */
/*private void deleteNode(Node node){
        if(node.prev!=null){
            node.prev.next = node.next;
        }
        if(node.next!=null){
            node.next.prev = node.prev;
        }
        if(node == tail){
            if(head == tail){
                head=tail = null;
            }else {
                tail = tail.prev;
            }
        }
        node.next=null;
        node.prev=null;
    }*//*


    */
/*private Node removeLast(){
        Node temp = tail;
        if(tail!=null){
            if(tail == head){
                tail = head = null;
            }
            else {
                tail = tail.prev;
                tail.next = null;
            }
        }
        return temp;
    }*//*

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(cacheMap.containsKey(key)){
            Node node = cacheMap.get(key);
            adjustListForGet(node);
            return node.value;
        }else{
            return -1;
        }

    }

    public void put(int key, int value) {
        if(capacity>0) {
            Node newnode = new Node();
            newnode.key = key;
            newnode.value = value;
            if (cacheMap.containsKey(key)) {
                Node node = cacheMap.get(key);
                node.value = value;
                adjustListForGet(node);
                return;
            */
/*cacheMap.remove(key);
            deleteNode(node);*//*

            }
            if (cacheMap.size() == capacity) {
                Node node = removeLast();
                if (node != null) {
                    cacheMap.remove(node.key);
                }
            }
            addToList(newnode);
            cacheMap.put(key, newnode);
        }
    }


    */
/*public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(2));
        lruCache.put(1,1);
        lruCache.put(4,1);
        System.out.println(lruCache.get(2));
        *//*
*/
/*System.out.println(lruCache.get(3));
        lruCache.put(4,4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));*//*
*/
/*
    }*//*

}
*/
