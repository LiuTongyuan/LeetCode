package DP;

/**
 * @Author 年年
 * @Date 2021/12/14 21:21
 * @Description LeetCode-312：戳气球
 * 对于一组气球，戳破i位置的就可以获得nums[i-1]*nums[i]*nums[i+1]个硬币，若在边缘则越界值默认为1，求按照最佳的选择最后获得硬币数
 * 本质上是一个博弈论的问题，每次选择出最好的选择
 * 当你有一组数组的时候，最佳的选择一定不是从边缘开始戳破，这样一定得不到最大硬币数
 * 假设序列为{a,b,c,...}
 * 假设上来戳破a，则得到<1,{b,c,...,z},1>,假设最后剩余的是m,n,则为<m,n>+ab+序列<1,{b,c,...,z},1>
 * 但是最后戳破a，得到的是<a,{b,c,...,z},1>,假设最后剩余的是m,n,则为<a,m,n>+序列<a,{b,c,...,z},1>
 * 至于在中间删除a则不用讨论,因为删到a时,对于剩下的序列,就是第一个删除的a。
 */
public class PokeTheBalloon {

    //错误原因nums[i]可能取0,当0出现在边界上0，需要先把0删掉,所以不一定是从内部开始删,
    /**
     * int[][] dp[i][j]表示删除i-j位置的序列可以得到的最大硬币数
     * 递推公式 dp[i][j] = Math.max(dp[i+1][j]+nums[i]*num[i-1]*num[j+1],dp[i][j-1]+nums[j]*num[j+1]*num[i-1])
     *
     * @param nums
     * @return
     */
    public int maxCoins1(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i; j < nums.length; j++) {
                int a = (i == 0) ? 1 : nums[i - 1];
                int b = nums[i];
                int c = nums[j];
                int d = (j == nums.length - 1) ? 1 : nums[j + 1];
                if (i == j) {
                    dp[i][j] = a * b * d;
                } else if(i == (j - 1)) {
                    dp[i][j] = Math.max(a*b*c+a*c*d,b*c*d+a*b*d);
                }else {
                    dp[i][j] = Math.max(dp[i + 1][j] +a*b*d, dp[i][j - 1] + a*c*d);
                }
            }
        }
        return dp[0][nums.length-1];
    }

    /**
     * int[][] dp[i][j]表示删除<i,...,j>位置的序列可以得到的最大硬币数
     * 递推公式 dp[i][j] = Math.max(dp[i][j], ((k==0)?0:dp[i][k-1])+a*d*nums[k]+((k==nums.length - 1)?0:dp[k+1][j]));
     *
     * @param nums
     * @return
     */
    public int maxCoins2(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i; j < nums.length; j++) {
                int a = (i == 0) ? 1 : nums[i - 1];
                int b = nums[i];
                int c = nums[j];
                int d = (j == nums.length - 1) ? 1 : nums[j + 1];
                if (i == j) {
                    dp[i][j] = a * b * d;
                } else if(i == (j - 1)) {
                    dp[i][j] = Math.max(a*b*c+a*c*d,b*c*d+a*b*d);
                }else {
                    for (int k = i; k <= j; k++) {
                        dp[i][j] = Math.max(dp[i][j], ((k==0)?0:dp[i][k-1])+a*d*nums[k]+((k==nums.length - 1)?0:dp[k+1][j]));
                    }
                }
            }
        }
        return dp[0][nums.length-1];
    }

    //预处理优化，用开区间表示
    /**
     *
     * @param nums
     * @return
     */
    public int maxCoins3(int[] nums) {
        int length = nums.length;
        int[] temp = new int[length+2];
        for (int i = 1; i <=length; i++) {
            temp[i] = nums[i-1];
        }
        temp[length+1] = 1;
        temp[0] = 1;
        int[][] dp = new int[length+2][length+2];
        for (int i = length-1; i >= 0; i--) {
            for (int j = i+2; j < length+2; j++) {
                for (int k = i+1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], temp[i]*temp[j]*temp[k]+dp[i][k]+dp[k][j]);
                }
            }
        }
        return dp[0][length+1];
    }

    public static void main(String[] args) {
        System.out.println(new PokeTheBalloon().maxCoins3(new int[]{1,2,3,4,5,6}));
    }
}
