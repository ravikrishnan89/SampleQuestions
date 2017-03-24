package Booking;

import java.util.Scanner;

/**
 * Created by ravi.krishnan on 01/11/16.
 */
public class SignedByte {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scanner = new Scanner(System.in);
        String numberString = scanner.nextLine();
        String [] numberStringArray = numberString.split(" ");
        int [] numberArray = new int[numberStringArray.length];
        int count = 0;
        for(String string: numberStringArray){
            numberArray[count++] = Integer.parseInt(string);
        }
        int [] diffArray = new int[numberArray.length];
        diffArray[0] = numberArray[0];
        for(int i=1;i<numberArray.length;i++){
            diffArray[i] = numberArray[i] - numberArray[i-1];
        }
        System.out.print(diffArray[0] + " ");
        for(int i=1;i<diffArray.length;i++){
            if(diffArray[i]>127 || diffArray[i]<-127){
                System.out.print(-128 + " ");
            }
            System.out.print(diffArray[i] + " ");
        }
    }

}
