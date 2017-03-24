/**
 * Created by ravi.krishnan on 07/12/16.
 */
public class XorProduct {

    public int solution(int M, int N) {
        int r=0;
        for(int i=M;i<=N;i++)
            r = r^i;
        return r;
    }


    public int copiedAndModified(int N){


        if (N < 0) {

            return 0;

        }



        switch (N % 4) {

            case 0:

                return N;

            case 1:

                return 1;

            case 2:

                return N + 1;

            case 3:

                return 0;

            default:

                return 0;

        }

    }

    public int solutionCopied(int M, int N){
        return copiedAndModified(N)^copiedAndModified(M-1);
    }
    public int f(int a){
        int res[] = {a,1,a+1,0};
        return res[(int)a%4];
    }
    public static void main(String[] args) {
        System.out.println(new XorProduct().solution(990000009,1000000000));
        System.out.println(new XorProduct().solutionCopied(990000009,1000000000));
    }
}
