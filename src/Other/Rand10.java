package Other;

/**
 * @Author 年年
 * @Date 2021/12/23 12:21
 * @Description 470. 用 Rand7() 实现 Rand10()
 * https://leetcode-cn.com/problems/implement-rand10-using-rand7/submissions/
 */
public class Rand10 {
    /**
     * 思路:每次使用rand7,情况扩大7倍,但是由于我们要的是rand10,永远不可能将情况均分为10份
     * 所以一定要做出舍弃，使剩下的情况均分为10份，没份对应一个数字。
     *
     * @return
     */
    public int rand10() {
        int a = rand7(), b = rand7();
        while (a == 4) {
            a = rand7();
        }
        a /= 4;
        while (b >= 6) {
            b = rand7();
        }
        return 5 * a + b;
    }

    public int rand7() {
        return 0;
    }
}
