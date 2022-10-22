package Array;

import java.util.HashSet;
import java.util.Set;

public class TwoSum {
    public static void main(String[] args) {
//        System.out.println(twoSum(new int[]{2,7,11,15},9).toString());
    }

    public int[] twoSum(int[] nums, int target) {
        Set<Integer> sets = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(sets.contains(target-nums[i])){
                for (int j = 0; j < i; j++) {
                    if(nums[j] == target-nums[i]){
                        return new int[]{j,i};
                    }
                }
            }else {
                sets.add(nums[i]);
            }
        }
        return null;
    }
}
