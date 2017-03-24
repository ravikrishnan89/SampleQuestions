/**
 * Created by ravi.krishnan on 31/10/16.
 */
public class PascalTriangle {
    long [][] values = new long[100][100];
    long [] current = new long[100];
    long [] previous = new long[100];
    public long getBinomialCoeff(int r, int c){
        values[0][0]=1;
        for(int i=1;i<r+1;i++){
            values[i][0]=1;
            values[i][i]=1;
            for(int j=1;j<=Math.min(i,c);j++){
                values[i][j] = values[i-1][j-1] + values[i-1][j];
            }

        }
        return values[r][c];
    }



    public long getBinomialCoeffPrev(int r, int c){
        for(int i=0;i<=r;i++){
            previous[0] = 1;
            current[0]=1;
            for(int j=1;j<=Math.min(i,c);j++){
                current[j] = previous[j-1] + previous[j];
            }
            for(int j=0;j<=Math.min(i,c);j++){
                previous[j]= current[j];
            }
        }
        return previous[c];
    }


    public static void main(String[] args) {
        System.out.println(new PascalTriangle().getBinomialCoeffPrev(5,3));
    }
}
