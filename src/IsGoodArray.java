/**
 * @Author lty
 * @Date 2023/2/15 16:28
 * @Description 1250. 检查「好数组」
 * https://leetcode.cn/problems/check-if-it-is-a-good-array/
 */
public class IsGoodArray {
    /**
     * 数论中的「裴蜀定理」：对于不全为零的任意整数 a 和 b，记 g=gcd(a,b)，其中 gcd(a,b)为 a 和 b 的最大公约数，
     * 则对于任意整数 x 和 y 都满足 a×x+b×y 是 g 的倍数，特别地，存在整数 x 和 y 满足 a×x+b×y=g。
     * @param nums
     * @return
     */
    public boolean isGoodArray(int[] nums) {
        int divisor = nums[0];
        for (int num : nums) {
            divisor = gcd(divisor, num);
            if (divisor == 1) {
                break;
            }
        }
        return divisor == 1;
    }

    public int gcd(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1;
            num1 = num2;
            num2 = temp % num2;
        }
        return num1;
    }
}
