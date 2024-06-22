import Map.MST.Kruskal;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

/**
 * @Author lty
 * @Date 2024/1/19 13:03
 * @Description 2809. 使数组和小于等于 x 的最少时间
 * hard
 */
public class Num2809_minimumTime {

    /**
     * 首先，假设你想在第 i < length 次操作得到最小和，那么你不能重复清理同一个：
     * 因为你在前一次去清理一个从未清理过的下表j，那么最后的值一定是比清理i小的，因为i后面会再次被置为0；
     *
     * 可以先求一个每次不操作的sum，减去操作带来的增益
     * 错误原因：我们每次选择了一个在该位置最大的元素，但是 他们的和可能是反过来更大
     *
     * @param nums1
     * @param nums2
     * @param x
     * @return
     */
    public int minimumTime(List<Integer> nums1, List<Integer> nums2, int x) {
        int[] arr1 = new int[nums1.size()];
        int[] arr2 = new int[nums2.size()];
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < nums1.size(); i++) {
            arr1[i] = nums1.get(i);
            arr2[i] = nums2.get(i);
            sum1 += arr1[i];
            sum2 += arr2[i];
        }
        int[] dp = new int[ arr1.length + 1];
        for (int i = 0; i <= arr1.length; i++) {
            Arrays.fill(dp, -1);
            // 操作次数 i
            int tempSum = sum1 + i * sum2;
            for (int j = 0; j < arr1.length; j++) {
                // k个数字
                int cur = j;
                for (int k = i; k > 0; k--) {
                    if(dp[k] == -1){
                        dp[k] = cur;
                        break;
                    }
                    // 竞争第k次操作
                    int numCur = arr1[cur] + arr2[cur] * k;
                    int numLast = arr1[dp[k]] + arr2[dp[k]] * k;

                    if (numCur > numLast) {
                        int temp = cur;
                        cur = dp[k];
                        dp[k] = temp;
                    } else if (numCur == numLast) {
                        if (arr2[cur] > arr2[dp[k]]) {
                            int temp = cur;
                            cur = dp[k];
                            dp[k] = temp;
                        }
                    }

                }
            }

            for (int j = i; j > 0; j--) {
                tempSum -= arr1[dp[j]] + j * arr2[dp[j]];
            }
            if (tempSum <= x) {
                return i;
            }
        }
        return -1;
    }
}
