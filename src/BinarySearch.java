/**
 * Created by ravi.krishnan on 11/11/16.
 */
public class BinarySearch {

    public static void main(String[] args) {
        int arr[] = {1, 5, 6 ,8 ,9 ,12 , 13 ,56,75};
        System.out.println(new BinarySearch().bSearch(arr, 0, arr.length -1, 0));
    }

    int bSearch(int arr[],int start, int end, int item){
        if(start>end){
            return start -1;
        }
        int mid = (start + end)/2;
        if(item>arr[mid]){
            return bSearch(arr, mid +1, end, item);
        }
        else if(item<arr[mid]){
            return bSearch(arr, start, mid -1, item);
        }
        else{
            return mid;
        }
    }


    int bSearchIt(int arr[],int start, int end, int item){
        while(start<=end){
            int mid = (start + end)/2;
            if(item>arr[mid]){
                start = mid +1;
            }  else if(item<arr[mid]){
                end = mid -1;
            }else{
                return mid;
            }
        }
        return start -1;
    }
}
