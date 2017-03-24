import java.util.Scanner;

/**
 * Created by ravi.krishnan on 31/10/16.
 */
public class Klargestelement {
    public class Heap{
        int [] arr;
        int size;

        private void buildHeap(){
            for(int i= (size )/2 -1; i>=0;i--)
                minheapify(i);
        }


        public Heap(int [] arr){
            this.arr = arr;
            size = arr.length;
            buildHeap();
        }
        public void insert(int elem){
            arr[0] = elem;
            minheapify(0);
        }

        public int getSmallest(){
            return arr[0];
        }

        private void swap(int i, int j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        private void minheapify(int index){
            if(index>=size)
                return;
            int l = 2*index +1;
            int r = 2*index +2;
            int smallest=index;
            if(l<size && arr[l]<arr[index])
                smallest = l;
            if(r<size && arr[r]<arr[smallest])
                smallest = r;
            if(smallest!=index){
                swap(index, smallest);
                minheapify(smallest);
            }
        }
    }

    public static void main(String[] args) {
        int k = 5;
        int [] arr = new int[k];
        Klargestelement klargestelement = new Klargestelement();
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        Heap heap=null;
        while(true) {
            int entered = scanner.nextInt();
            if (count < k - 1) {
                arr[count] = entered;
            } else if (count == k - 1) {
                arr[count] = entered;
                heap = klargestelement.new Heap(arr);
                heap.buildHeap();
                System.out.println("Kthe largest is " + heap.getSmallest());
            } else {
                if (entered>heap.getSmallest()){
                    heap.insert(entered);
                }
                System.out.println("Kthe largest is " + heap.getSmallest());
            }
            count ++;
        }
    }
}
