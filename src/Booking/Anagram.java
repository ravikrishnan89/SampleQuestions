package Booking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ravi.krishnan on 01/11/16.
 */
public class Anagram {


    boolean areTheStringsAnagram(String str1, String str2)
    {
       int charLimit = 257;
       int [] countstr1 = new int[charLimit];
       int [] countstr2 = new int[charLimit];
        // For each character in input strings, increment count in
        // the corresponding count array
        for(int i=0;i<str1.length();i++){
            char c = str1.charAt(i);
            if(c == ' '){
                continue;
            }
            countstr1[c]++;
        }

        for(int i=0;i<str2.length();i++){
            char c = str2.charAt(i);
            if(c == ' '){
                continue;
            }
            countstr2[c]++;
        }
        for(int i=0;i<charLimit;i++){
            if(countstr1[i]!=countstr2[i]){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s;
        try {
            while ((s = in.readLine()) != null && s.length() != 0) {
                list.add(s);
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Collections.sort(list);
        List<String> angramList = new ArrayList<>();
        boolean[] done = new boolean[list.size()];
        Anagram anagram = new Anagram();

        for(int i=0;i<list.size();i++){
            if(done[i])
                continue;
            System.out.print(list.get(i));
            for(int j=i+1;j<list.size();j++){
                if(anagram.areTheStringsAnagram(list.get(i),list.get(j))){
                    done[j] = true;
                    System.out.print("," + list.get(j));
                }
            }
            System.out.println();
        }
    }
}
