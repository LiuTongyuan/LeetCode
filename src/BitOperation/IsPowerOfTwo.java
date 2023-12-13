package BitOperation;

/**
 * @Author 年年
 * @Date 2021/12/23 9:34
 * @Description LeetCode-231:2的幂
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
 */
public class IsPowerOfTwo {
    /**
     * 当一个数字是2的幂的时候，它仅有一位1，也就是说消去1之后为0
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    /**
     * 方法二：当一个数字是2的幂的时候，可以被2^31整除
     * 注意：思考下为什么强转为int会出错
     * @param n
     * @return
     */
    public boolean isPowerOfTwo2(int n) {
        return n > 0 && (((long) Math.pow(2, 31)) % n == 0);
    }
}
