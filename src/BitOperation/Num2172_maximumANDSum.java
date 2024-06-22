package BitOperation;

/**
 * @Author lty
 * @Date 2024/1/3 19:49
 * @Description
 */
public class Num2172_maximumANDSum {
    int maxSum = 0;

    /**
     * 回溯：超时
     * @param nums
     * @param numSlots
     * @return
     */
    public int maximumANDSum(int[] nums, int numSlots) {
        int[] count = new int[numSlots + 1];
        backTrack(nums, numSlots, count, 0, 0);
        return maxSum;
    }

    public void backTrack(int[] nums, int numSlots, int[] count, int index, int sum) {
        if (index == nums.length) {
            maxSum = Math.max(maxSum, sum);
            return;
        }
        for (int i = 1; i <= numSlots; i++) {
            if (count[i] < 2) {
                count[i]++;
                backTrack(nums, numSlots, count, index + 1, sum + (i & nums[index]));
                count[i]--;
            }
        }
    }

    // public int maximumANDSum2(int[] nums, int numSlots) {
    //     int[][] temp = new int[nums.length][numSlots+1];
    //     for (int i = 0; i < ; i++) {
    //
    //     }
    // }
    
}
