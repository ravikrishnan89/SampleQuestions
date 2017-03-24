/**
 * Created by ravi.krishnan on 24/11/16.
 */
public class RepeatingAndMissing {

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,7};
        int length = arr.length;
        int xor=1;
        for(int i=2;i<=length;i++){
            xor = xor ^ i;
        }
        for(int i=0;i<length;i++){
            xor = xor^arr[i];
        }
        int setBit = xor & ~(xor -1);
        int first = -1, second=-1;
        for(int i=0;i<length;i++){
            int n = arr[i]&setBit;
            if(n==1){
                if(first == -1){
                    first = arr[i];
                }else {
                    first = first ^ arr[i];
                }
            }else{
                if(second == -1) {
                    second = arr[i];
                }else{
                    second = second ^ arr[i];
                }
            }
        }

        for(int i=1;i<=length;i++){
            int n = i&setBit;
            if(n==1){
                first = first^i;
            }else{
                second = second ^i;
            }
        }

        System.out.println("First " +first + "second " + second);
    }
}
