/**
 * Created by ravi.krishnan on 02/12/16.
 */
public class MaximumSubstring {



    static int getMinimumSubStringLength(String a, String pattern){

         int [] hashA = new int[256];
        int [] hashPattern = new int[256];


        for(int i=0;i<pattern.length();i++){
            hashPattern[pattern.charAt(i)]++;
        }
        int start = 0;
        int end = 0;
        int length = Integer.MAX_VALUE;
        int minstart =0, minEnd=0;
        while(true){
            while(!compare(hashA,hashPattern)&&end<a.length()){
                hashA[a.charAt(end)]++;
                end++;
            }
            if(end == a.length()){
                break;
            }
            while(hashA[a.charAt(start)] >=hashPattern[a.charAt(start)]){
                start++;
                hashA[a.charAt(start)]--;
            }
            if(end - start < length){
                length = end - start;
                minstart = start ;
                minEnd = end-1;
            }
        }
        return length;
    }

    public static boolean compare(int []hasha, int []hashpattern){
        for(int i=0;i<hasha.length;i++){
            if(hasha[i]<hashpattern[i])
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String a = "this is brock lesnar";
        String b = "isb";
        getMinimumSubStringLength(a,b);
    }
}
