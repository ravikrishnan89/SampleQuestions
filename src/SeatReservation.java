import java.util.HashMap;
import java.util.Map;

/**
 * Created by ravi.krishnan on 16/11/16.
 */
public class SeatReservation {

    boolean [][] groupList;
    Map<Integer,Map<String,Boolean>> mapList;
    public int solution(int N, String S) {
        // write your code in Java SE 8

        String [] seats = S.split(" ");
        groupList = new boolean[N][3];
        mapList = new HashMap<>();

        for(int i=0;i<N;i++){
            for(int j=0;j<3;j++){
                groupList[i][j]= false;
            }
        }
        if(!S.isEmpty()) {
            for (String seat : seats) {
                String column = seat.substring(seat.length()-1, seat.length());
                String row = seat.substring(0, seat.length()-1);
                int rowIndex;
                try {
                    rowIndex = Integer.parseInt(row) - 1;
                }catch (NumberFormatException e){
                    continue;
                }
                Map<String, Boolean> map = mapList.get(rowIndex);
                if (map == null) {
                    map = new HashMap<String, Boolean>();
                    mapList.put(rowIndex, map);
                }
                map.put(column, true);
                setGroupListValueBasedOnSeat(rowIndex, column);
            }
        }
        int count = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<3;j++){
                if(!groupList[i][j]){
                    count ++;
                }
            }
        }
        return count;
    }

    public void setGroupListValueBasedOnSeat(int row, String columnString){
        char column = columnString.charAt(0);
        if(column>='A' && column<='C'){
            groupList[row][0] = true;
        }else if(column>='H' && column <='K'){
            groupList[row][2] = true;
        }else if(column == 'E' || column == 'F'){
            groupList[row][1] = true;
        }else{
            if(column == 'D'){
                if(mapList.get(row)!=null && mapList.get(row).containsKey("G")){
                    groupList[row][1] = true;
                }
            }else{
                if(mapList.get(row)!=null && mapList.get(row).containsKey("D")){
                    groupList[row][1] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        new SeatReservation().solution(120,"1A 3C 2B 40G 5A 10G 111G 111D");
    }
}
