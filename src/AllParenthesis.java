/**
 * Created by ravi.krishnan on 29/11/16.
 */
public class AllParenthesis {


    public static void printAllPossible(int total){
        char [] chars = new char[ 2* total];
        printBalanced(total,total,chars, 0);
    }
    public static void printAllPossible(int l, int r, char[] chars, int count){
        for(int i=0;i<r - l;i++){
            chars[count++] = '}';
        }
        r = l;
        if(l == 0)
            System.out.println(chars);
        for(int i=0;i<l;i++){
            chars[count++] = '{';
            printAllPossible(l-i -1,r, chars, count);
        }
    }


    /*public static void printBalanced(int left, int right, char [] str,  int count){
        if(left == 0 && right == 0){
            System.out.println(str);
            return;
        }
        for(int i=0;i<right - left;i++){
            str[count ++] = ')';
        }
        if(left>0) {
            for (int i = 0; i < left; i++) {
                str[count++] = '(';
                printBalanced(left - i - 1, left, str, count);
            }
        }else{
            printBalanced(0, 0, str, count);
        }
        }*/

    public static void printBalanced(int left, int right, char [] str,  int count){
        if(left == 0 && right == 0){
            System.out.println(str);
            return;
        }
        if(left>0){
            str[count] = '(';
            printBalanced(left -1, right,str, count+1);
        }
        if(right>left){
            str[count] = ')';
            printBalanced(left, right -1 ,str, count+1);
        }
    }
    public static void main(String[] args) {
        printAllPossible(2);
    }
}
