import java.util.HashMap;
import java.util.Map;

/**
 * Created by ravi.krishnan on 01/11/16.
 */
public class Solution {

    Map<Integer, Integer> integerMap = new HashMap<>();
    public int[] twoSum(int[] nums, int target) {
        int[] indexArray = new int[2];
        for(int i=0;i<nums.length;i++){
            integerMap.put(target - nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            if(integerMap.containsKey(nums[i])){
                if(i!=integerMap.get(nums[i])) {
                    indexArray[0] = i;
                    indexArray[1] = integerMap.get(nums[i]);
                    break;
                }
            }
        }
        return indexArray;
    }
}
