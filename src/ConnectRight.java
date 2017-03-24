import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ravi.krishnan on 30/10/16.
 */
public class ConnectRight {

    public static class Tree<T> {

        Tree(T data){
            this.data = data;
            this.left = null;
            this.right = null;
            this.siblingRight = null;
        }
        Tree left;
        Tree right;
        Tree siblingRight;
        T data;
    }

    public void connectRight(Tree root) {
        Queue<Tree> queue = new LinkedList<>();
        int count = 1;
        queue.add(root);
        while (!queue.isEmpty()) {
            Tree prevNode = null;
            int tempCount = 0;
            while (count-- > 0) {
                Tree node = queue.poll();
                if (prevNode != null) {
                    prevNode.siblingRight = node;
                }
                if (node.left != null) {
                    queue.add(node.left);
                    tempCount++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    tempCount++;
                }
                prevNode = node;
            }
            count = tempCount;
        }
    }

    public void connectRightRec(Tree root){
        if(root == null){
            return;
        }
        if(root.left!=null) {
            if(root.right!=null) {
                root.left.siblingRight = root.right;
            }
            else{
                root.left.siblingRight = getSiblingRight(root.siblingRight);
            }
        }
        if(root.right!=null) {
            root.right.siblingRight = getSiblingRight(root.siblingRight);

        }
        connectRightRec(root.siblingRight);
        if(root.left!=null)
            connectRightRec(root.left);
        else
            connectRightRec(root.right);
    }


    public Tree getSiblingRight(Tree root){
        if(root == null)
            return null;
        while(root!=null){
            if(root.left!=null)
                return root.left;
            else if(root.right!=null)
                return root.right;
            root = root.siblingRight;
        }
        return null;
    }

    public void levelPrint(Tree root){
        while(root!=null){
            printRight(root);
            root = root.left;
        }
    }
    public void printRight(Tree node){
        while(node!=null){
            System.out.println(node.data);
            node = node.siblingRight;
        }
    }
    public static void main(String[] args) {
        Tree<Integer> root = new Tree<Integer>(1);
        root.left = new Tree<Integer>(2);
        root.right = new Tree(5);
        root.left.left =  new Tree(3);
        root.left.right =  new Tree(4);
        root.right.right =  new Tree(7);
        root.right.left =  new Tree(6);
        root.left.left.left =  new Tree(8);
        root.left.right.left = new Tree(9);
        root.right.right.right = new Tree(10);
        new ConnectRight().connectRight(root);
        new ConnectRight().levelPrint(root);
    }
}
