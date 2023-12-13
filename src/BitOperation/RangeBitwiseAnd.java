package BitOperation;

/**
 * @Author 年年
 * @Date 2021/12/23 9:22
 * @Description LeetCode-201:数字范围按位与
 * https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/
 * 给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内
 * 所有数字 按位与 的结果（包含 left 、right 端点）。
 */
public class RangeBitwiseAnd {
    /**
     * 方法一：每次 &right-1
     * 为什么这样可以获得所有数字按位与的结果？
     * 所有数字按位与操作之后获得的结果就是他们的公共前缀
     * 因为 比如一个数字n, 它的[(n&(n-1)),n]这个范围内的数字的公共前缀就是(n&(n-1)),也就
     * 是说当n和(n-1)按位与操作之后，后续的与操作都是无效操作，所以可以跳过了
     * @param left
     * @param right
     * @return
     */
    public int rangeBitwiseAnd(int left, int right) {
        while (left < right) {
            right &= right - 1;
        }
        return right;
    }
}
