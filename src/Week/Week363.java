package Week;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lty
 * @Date 2023/9/17 22:57
 * @Description
 */
public class Week363 {
    public static void main(String[] args) {
        int[] arr = new int[]{35, 45, 29, 16, 42, 49, 25, 19, 46};
        List list = new ArrayList();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        System.out.println(new Week363().maximumSum(list));

    }

    /**
     * @param n           种金属
     * @param k           台机器
     * @param budget      预算
     * @param composition 机器i需要composition[i][j]份i金属
     * @param stock       最初拥有stock[i] 份 i 类型金属
     * @param cost        每购入一份 i 类型金属需要花费 cost[i] 的金钱。
     * @return
     */
    public static int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        long maxNum = 0;
        for (int i = 0; i < k; i++) {
            // 遍历每种合金,i表示合金种类
            List<Integer> numOfEach = composition.get(i);

            long l = 0, r = Integer.MAX_VALUE;
            long middle = 0;
            // l能完成，r可以完成，可以完不成。

            while (l < r) {
                long extraBud = 0;
                middle = l + (r + 1 - l) / 2;
                // 判断middle份是否能够完成
                for (int j = 0; j < n; j++) {
                    extraBud += (cost.get(j) * Math.max(middle * numOfEach.get(j) - stock.get(j), 0));
                }
                if (extraBud > budget) {
                    // 完不成
                    r = middle - 1;
                } else {
                    // 能完成
                    l = middle;
                }

            }
            maxNum = Math.max(maxNum, (long) l);
        }
        return (int) maxNum;
    }

    /**
     * @param nums
     * @return
     */
    public long maximumSum(List<Integer> nums) {
        if (nums.size() == 0) {
            return 0;
        }
        long max = 0;
        long[] dp = new long[nums.size() + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = nums.get(i - 1);
        }

        for (int i = 1; i < dp.length; i++) {
            if (isW(i) && i > 1) {
                int k = (int) Math.sqrt(i - 1);
                dp[i] = Math.max(dp[i], dp[k * k] + nums.get(i - 1));
            }
            for (int j = 2; j <= (int) Math.sqrt(i); j++) {
                if (i % (j * j) == 0) {
                    dp[i] = Math.max(dp[i], dp[i / (j * j)] + nums.get(i - 1));

                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static boolean isW(int num) {
        int sqr = (int) Math.sqrt(num);

        return num == sqr * sqr;

    }
}
