/**
 * @Author lty
 * @Date 2023/10/17 10:10
 * @Description 2652. 倍数求和
 * https://leetcode.cn/problems/sum-multiples/description/
 */
public class Num2652_SumOfMultiples {
    public static void main(String[] args) {
        System.out.println(new Num2652_SumOfMultiples().sumOfMultiples(9));
    }

    /**
     * 思路：集合问题考虑多加的和多减的即可。
     *
     * @param n
     * @return
     */
    public int sumOfMultiples(int n) {
        int res = 0;
        res += getOne(n, 3);
        res += getOne(n, 5);
        res += getOne(n, 7);
        res -= getOne(n, 3 * 5);
        res -= getOne(n, 3 * 7);
        res -= getOne(n, 5 * 7);
        res += getOne(n, 3 * 5 * 7);
        return res;
    }

    public int getOne(int n, int num) {
        int count = n / num;
        return num * count * (count + 1) / 2;
    }
}
