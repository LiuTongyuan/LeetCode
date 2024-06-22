package BackTrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author lty
 * @Date 2024/1/3 16:07
 * @Description 77. 组合
 * 回溯 位操作
 */
public class Num77_combine {
    public static void main(String[] args) {
        int m1 = 11, j = 2;
        System.out.println(~m1 & (m1 + 1));
        System.out.println(Integer.bitCount(j) - 1);
        System.out.println((1 << Integer.bitCount(j)) - 1);
        System.out.println((1 << (Integer.bitCount(j) - 1)) - 1);
        new Num77_combine().combine2(4, 2);
    }

    /**
     * 方法一遍历
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            if (Integer.bitCount(i) == k) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    if ((i & (1 << j)) != 0) {
                        temp.add(j + 1);
                    }
                }
                res.add(temp);
            }
        }
        return res;
    }


    /**
     * 方法二 实质，剪枝
     * 方法一其实一直在找有k位为1的数字，我们知道k位为1的数字之间一定有一个大小关系，那么我们的优化思路就可以是：
     * 已知上一个k位为1的数字，如何找下一个？
     * 首先我们可以想到一定是只有一位移动，那么移动哪一位呢？不要忘了我们是要按顺序的，也就是我们要让增大值最小？
     * 可以分为 source位 和 target位 也就是由 m + 2^source -> m + 2^target
     * target位要够小，所以我们选择从右往左第一个0，target就可以选择它右边的1！！！
     * 出现问题：如果第1位为0怎么办？即 0_n_(0)_11_0 ? 01100  10001   ~i + 1最右边有几位0
     * 可以想到在 +1 的过程中， 先是最右边变为1，这样子多了一个1！！！
     * 可以让第一个可以左移的1左移，然后它右边可以右移的1移动到最右边！！！
     * <p>
     * i 000    n 01111000->n 01111111->0 11111111->0 01111000->n10000111
     * <p>
     * i | (i - i) 00001111111
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = (1 << k) - 1; i < 1 << n; ) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    temp.add(j + 1);
                }
            }
            res.add(temp);
            if ((i & 1) != 0) {
                i = (i | (i + 1)) - ((~i & (i + 1)) >>> 1);
            } else {
                int m = i; // n 001010
                int m1 = m | (m - 1); // n 001011
                int mask = m1 ^ (m1 + 1); // 0 000111
                int j = i & mask; // 0 000010
                int r = (~m1 & (m1 + 1)) | ((1 << (Integer.bitCount(j) - 1)) - 1); // 0 001001
                i = i & (~mask) | (r);
            }

        }
        return res;
    }

    /**
     * @param n
     * @param k
     * @return
     */
    List<List<Integer>> res = new ArrayList();
    LinkedList<Integer> comb = new LinkedList();

    public List<List<Integer>> combine3(int n, int k) {
        combineH(n, k, 1);
        return res;
    }

    public void combineH(int n, int k, int startIndex) {
        if (comb.size() == k) {
            res.add(new ArrayList(comb));
            // System.out.print(res);
            return;
        }
        for (int i = startIndex; i <= (n - (k - comb.size()) + 1); i++) {
            comb.add(i);
            combineH(n, k, i + 1);
            comb.removeLast();
        }
    }

}
