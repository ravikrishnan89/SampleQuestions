import java.util.Scanner;

/**
 * Created by ravi.krishnan on 24/10/16.
 */
public class Wordwrap {


    int lineLength = 15;
    String [] words;
    int [] cache;

    public int calculateWordwrapCost( int startIndex, int previousLength){
        if(startIndex>=words.length)
            return 0;
        if(cache[startIndex]==-1) {
            int currentLength = 0;
            int cost = Integer.MAX_VALUE;
            for (int i = startIndex; i < words.length && currentLength + words[i].length() <= lineLength; i++) {
                if(i>startIndex) {
                    currentLength += words[i].length() + 1;
                }else{
                    currentLength += words[i].length() ;
                }
                int extraspaces = lineLength - currentLength;
                int currentCost = extraspaces * extraspaces  + calculateWordwrapCost(i + 1, currentLength + previousLength);
                if (cost > currentCost) {
                    cost = currentCost;
                }
            }
            cache[startIndex] = cost;
        }
        return cache[startIndex];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Wordwrap wordwrap = new Wordwrap();
        wordwrap.words = scanner.nextLine().split(" ");
        wordwrap.cache = new int[wordwrap.words.length];
        for(int i=0;i<wordwrap.cache.length;i++){
            wordwrap.cache[i] =-1;
        }
        int cost = wordwrap.calculateWordwrapCost(0,0);
        System.out.println("Cost is "+cost);
    }
}
