/**
 * Created by ravi.krishnan on 29/10/16.
 */
public class QuickSort {



    private void swap(int a[],int pos1, int pos2){
        int temp = a[pos1];
        a[pos1] = a[pos2];
        a[pos2] = temp;
    }

    private  void quicksort(int [] a, int start, int end){
        //int mid = (start + end)/2;
        if(start>=end)
            return;
        int initialStart = start;
        int initialEnd = end;
        int pivot = end;
        start = start -1;
        while(true){
            while(start < end && a[++start]< a[pivot]);
            while(end > start && a[--end] > a[pivot]);
            if(start<end)
                swap(a,start, end);
            else
                break;
        }
        swap(a, pivot,start);
        quicksort(a, initialStart, start-1);
        quicksort(a, start + 1, initialEnd);
    }
    public void sort(int [] arr){
        quicksort(arr, 0, arr.length -1);
    }


    public static void main(String[] args) {
        int a[] = {12, 78,4, 10, 15,0, -3, 100, 55, 78, 79, 105, 23, 0};
        new QuickSort().sort(a);
        for(int el: a){
            System.out.println(el);
        }
    }
}
