package BackTrack;

/**
 * @Author lty
 * @Date 2023/10/25 10:04
 * @Description 2698. 求一个整数的惩罚数
 * https://leetcode.cn/problems/find-the-punishment-number-of-an-integer/description/
 */
public class Num2698_PunishmentNumber {
    /**
     * 其实就是遍历i = 1...n，判断哪个数字的平方和可以分割为子字符串并且和为i。
     *
     * @param n
     * @return
     */
    public int punishmentNumber(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (check(i * i, i)) {
                res += i * i;
            }
        }
        return res;
    }

    public static boolean check(int n, int target) {
        if (n == 0 || target == 0) {
            return n == 0 && target == 0;
        }
        int d = 10;
        while (n >= d && n % d <= target) {
            if (check(n / d, target - n % d)) {
                return true;
            }
            d *= 10;
        }
        return target == n;
    }

    public static void main(String[] args) {
        System.out.println(new Num2698_PunishmentNumber().punishmentNumber(37));
    }
}
