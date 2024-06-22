package SlidingWindow.DefineLen;

/**
 * @Author lty
 * @Date 2023/12/27 19:45
 * @Description 2653. 滑动子数组的美丽值
 */
public class Num2653_GetSubarrayBeauty {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int[] count = new int[101];
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            count[nums[i] - 50]++;
        }
        res[0] = findMinX(count, x);
        for (int i = k; i < nums.length; i++) {
            count[nums[i] - 50]++;
            count[nums[i - k] - 50]++;
            res[i - k + 1] = findMinX(count, x);
        }
        return res;
    }

    public int findMinX(int[] count, int x) {
        int sum = 0;
        for (int i = 0; i < count.length; i++) {
            sum += count[i];
            if (sum >= x) {
                return Math.min(i - 50, 0);
            }
        }
        return 0;
    }
}
