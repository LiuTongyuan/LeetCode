package Week;

import java.util.Arrays;

/**
 * @Author lty
 * @Date 2024/4/10 19:23
 * @Description
 */
public class New4_13 {
    public static int one(int[][] pic) {
        int[][] oneCount = new int[pic.length + 2][pic[0].length + 2];
        int maxOneCount = 0;
        for (int i = 0; i < pic.length; i++) {
            for (int j = 0; j < pic[i].length; j++) {
                if (pic[i][j] == '*') {
                    oneCount[i][j + 1]++;
                    oneCount[i + 2][j + 1]++;
                    oneCount[i + 1][j]++;
                    oneCount[i + 1][j + 2]++;
                }
            }
        }
        for (int i = 0; i < oneCount.length; i++) {
            for (int j = 0; j < oneCount[0].length; j++) {
                maxOneCount = Math.max(maxOneCount, oneCount[i][j]);
            }
        }
        return maxOneCount == 2 ? 'L' : 'T';
    }

    public static int maxGcd = 0;

    public static int two(int[] nums) {
        int sum = 0;
        int[] count = new int[1001];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            count[nums[i]]++;
        }
        boolean[] dp = new boolean[(sum + 1) / 2 + 1];
        dp[0] = true;

        for (int i = 0; i < nums.length; i++) {
            for (int j = dp.length - 1; j > nums[i]; j--) {
                dp[j] = dp[j - nums[i]] || dp[j];
            }
            dp[nums[i]] = true;
        }

        for (int i = dp.length - 1; i > maxGcd; i--) {
            if (dp[i]) {
                maxGcd = Math.max(maxGcd, gcd(sum - i, i));
            }

        }


        return maxGcd;
    }


    public static int gcd(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        if (b > a) {
            int temp = a;
            a = b;
            b = temp;
        }
        while (a % b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return b;

    }

    // public static int three() {
    //
    // }


    public static void main(String[] args) {
        int[] array = new int[1000];
        Arrays.fill(array, 1000);
        two(array);
    }




}
