package SlidingWindow.DefineLen;

import java.util.Arrays;

/**
 * @Author lty
 * @Date 2023/12/27 16:51
 * @Description 2090. 半径为 k 的子数组平均值
 */
public class Num2090_GetAverages {
    public int[] getAverages(int[] nums, int k) {
        if (k == 0) {
            return nums;
        }
        int n = nums.length, t = 2 * k + 1;
        long sum = 0;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        if (n < t) {
            return ans;
        }
        for (int i = 0; i < t; i++) {
            sum += nums[i];
        }
        ans[k] = (int) (sum / t);
        for (int i = t; i < n; i++) {
            sum += nums[i] - nums[i - t];
            ans[i - k] = (int) (sum / t);
        }
        return ans;
    }
}
