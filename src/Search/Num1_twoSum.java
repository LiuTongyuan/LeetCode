package Search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Level;

/**
 * @Author lty
 * @Date 2024/1/9 14:44
 * @Description
 */
public class Num1_twoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(hashMap.containsKey(target - nums[i])){
                return new int[]{hashMap.get(target - nums[i]),i};
            }else {
                hashMap.put(nums[i], i);
            }
        }
        return null;
    }
}
