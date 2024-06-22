import java.util.Arrays;

/**
 * @Author lty
 * @Date 2023/12/28 09:49
 * @Description 2735. 收集巧克力
 */
public class Num2735_MinCost {
    public long minCost(int[] nums, int x) {
        // 记录每个位置最小购买值
        int[] minCos = Arrays.copyOf(nums, nums.length);

        long temp = 0;
        long minTotalCost = 0;
        for (int i = 0; i < nums.length; i++) {
            minTotalCost += nums[i];
        }
        for (int i = 1; i < nums.length; i++) {
            temp = 0;
            for (int j = 0; j < nums.length; j++) {
                minCos[j] = Math.min(minCos[j], nums[(j - i + nums.length) % nums.length]);
                temp += minCos[j];
            }
            minTotalCost = Math.min(minTotalCost, temp + (long) i * x);
        }
        return minTotalCost;
    }
}
