package Array;

import java.util.HashSet;
import java.util.Set;

public class TwoSum {
    public static void main(String[] args) {
       // System.out.println(twoSum2(new int[]{2,7,11,15},9));
    }

    public int[] twoSum(int[] nums, int target) {
        Set<Integer> sets = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (sets.contains(target - nums[i])) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] == target - nums[i]) {
                        return new int[]{j, i};
                    }
                }
            } else {
                sets.add(nums[i]);
            }
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        //错误原因，输入数组是无序的
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (nums[l] + nums[r] < target) {
                l++;
            } else if (nums[l] + nums[r] > target) {
                r--;
            } else {
                return new int[]{l, r};
            }
        }
        return null;
    }


}
