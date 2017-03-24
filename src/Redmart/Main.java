package Redmart;

/**
 * Created by ravi.krishnan on 17/01/17.
 */


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main {

    // initialize variables
    private static int[][] grid = new int[1][1];
    private static int currentLength = -1;
    private static int currentDrop = -1;
    private static int x = -1;
    private static int y = -1;
    private static int maxLength = -1;
    private static int maxDrop = -1;
    private static int maxX = -1;
    private static int maxY = -1;

    public static void main(String[] args) {
        try {
            // Open the file
            // filename is the first argument
            System.out.println(System.currentTimeMillis());
            FileInputStream fstream = new FileInputStream("/Users/ravi.krishnan/Desktop/skiing");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

            String strLine;

            if ((strLine = br.readLine()) != null) {
                String[] size = strLine.split(" ");
                x = Integer.parseInt(size[0]);
                y = Integer.parseInt(size[1]);
                grid = new int[x][y];

                System.out.println ("x: " + x);
                System.out.println ("y: " + y);
            }

            //Read File Line By Line
            int counterX = 0;
            while ((strLine = br.readLine()) != null)   {
                // Print the content on the console
                // System.out.println (strLine);

                String[] line = strLine.split(" ");
                int counterY = 0;
                for (String num : line) {
                    grid[counterX][counterY] = Integer.parseInt(num);
                    counterY++;
                }
                counterX++;
            }

            //Close the input stream
            br.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(System.currentTimeMillis());
        // DFS through every coordinate
        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++) {
                currentLength = recurFindLength(i, j);
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    maxX = i;
                    maxY = j;
                }else if (currentLength == maxLength) {
                    // if there is more than one path of max length, compare depths of paths
                    // using the DFS algorithm but saving each step into an arraylist of pairs
                    // depth/drop is calculated by taking the difference between the value of the first and the last coordinates
                    ArrayList<Pair<Integer, Integer>> currentList = findPath(i, j);
                    ArrayList<Pair<Integer, Integer>> maxList = findPath(maxX, maxY);
                    currentDrop = grid[currentList.get(0).getLeft()][currentList.get(0).getRight()] - grid[currentList.get(currentList.size() - 1).getLeft()][currentList.get(currentList.size() - 1).getRight()];
                    maxDrop =  grid[maxList.get(0).getLeft()][maxList.get(0).getRight()] - grid[maxList.get(maxList.size() - 1).getLeft()][maxList.get(maxList.size() - 1).getRight()];
                    if (currentDrop > maxDrop) {
                        maxDrop = currentDrop;
                        maxX = i;
                        maxY = j;
                    }
                }
            }
        }

        System.out.println();

        System.out.println("Max Length: " + maxLength);
        System.out.println("Max Drop: " + maxDrop);
        System.out.println(System.currentTimeMillis());
        ArrayList<Pair<Integer, Integer>> lengthList = findPath(maxX, maxY);
        // print out full path
        for (Pair<Integer, Integer> temp : lengthList) {
            System.out.println("(" + (temp.getLeft() + 1) + "," + (temp.getRight() + 1) + ", Value: " + grid[temp.getLeft()][temp.getRight()] + ")");
        }
    }

    // DFS to find longest path from a given coordinate
    private static int recurFindLength(int a, int b) {
        int currentNum = grid[a][b];
        // don't search for values less than current max length
        /*if (currentNum < maxLength) {
            return 0;
        }*/
        int temp = 0;
        if (b > 0 && currentNum > grid[a][b - 1]) { // up
            int newTemp = recurFindLength(a, b - 1);
            if (newTemp > temp) {
                temp = newTemp;
            }
        }
        if (b < (y - 1) && currentNum > grid[a][b + 1]) { // down
            int newTemp = recurFindLength(a, b + 1);
            if (newTemp > temp) {
                temp = newTemp;
            }
        }
        if (a > 0 && currentNum > grid[a - 1][b]) { // left
            int newTemp = recurFindLength(a - 1, b);
            if (newTemp > temp) {
                temp = newTemp;
            }
        }
        if (a < (x - 1) && currentNum > grid[a + 1][b]) { // right
            int newTemp = recurFindLength(a + 1, b);
            if (newTemp > temp) {
                temp = newTemp;
            }
        }
        return temp + 1;
    }

    // DFS to find longest path from a given coordinate but returns an arraylist of
    // pairs representing the full path
    private static ArrayList<Pair<Integer, Integer>> findPath(int a, int b) {
        int currentNum = grid[a][b];
        ArrayList<Pair<Integer, Integer>> tempList = new ArrayList<Pair<Integer, Integer>>();
        if (b > 0 && currentNum > grid[a][b - 1]) { // up
            ArrayList<Pair<Integer, Integer>> newList = findPath(a, b - 1);
            if (newList.size() > tempList.size()) {
                tempList = newList;
            }
        }
        if (b < (y - 1) && currentNum > grid[a][b + 1]) { // down
            ArrayList<Pair<Integer, Integer>> newList = findPath(a, b + 1);
            if (newList.size() > tempList.size()) {
                tempList = newList;
            }
        }
        if (a > 0 && currentNum > grid[a - 1][b]) { // left
            ArrayList<Pair<Integer, Integer>> newList = findPath(a - 1, b);
            if (newList.size() > tempList.size()) {
                tempList = newList;
            }
        }
        if (a < (x - 1) && currentNum > grid[a + 1][b]) { // right
            ArrayList<Pair<Integer, Integer>> newList = findPath(a + 1, b);
            if (newList.size() > tempList.size()) {
                tempList = newList;
            }
        }
        ArrayList<Pair<Integer, Integer>> temp = new ArrayList<Pair<Integer, Integer>>();
        temp.add(new Pair<Integer, Integer>(a, b));
        temp.addAll(tempList);
        return temp;
    }
}
