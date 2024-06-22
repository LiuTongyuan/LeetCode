package Week;

/**
 * @Author lty
 * @Date 2024/4/22 19:23
 * @Description
 */
public class New4_22 {
    public static int one(int n) {
        // f(n) = 26^(n-1) * C[(n-1)_3]        16%
        // f(n) = f(n-1) * 26 + 26^(2) * C[(n-1)_2]    3%
        // f(n) = f(n-1) * 26 + 26^(n-1) * C[(n-1)_2]      ?%
        return (int) f(n);

    }

    public static long f(int n) {
        if (n < 3) {
            return 0;
        } else if (n == 3) {
            return 676;
        } else {
            return (f(n - 1) *  26 % (1000000007) + (n-1) * (long) (n - 2) / 2 % (1000000007) * 676 % (1000000007))% (1000000007);
        }
    }

    public static int two(char[] color, int[][] edges) {
        int[] nextRed = new int[color.length];
        for (int i = 0; i < edges.length; i++) {
            if (color[edges[i][1]] == 'R') {
                nextRed[edges[i][0]]++;
            }
            if (color[edges[i][0]] == 'R') {
                nextRed[edges[i][1]]++;
            }
        }
        int sum = 0;
        int max = 0;
        for (int i = 0; i < nextRed.length; i++) {
            if (color[i] == 'R') {
                sum += nextRed[i];
            } else {
                max = Math.max(max, nextRed[i]);
            }
        }
        return sum + max;
    }

    public static int three(int n, String s, String t, int k) {

        // 思路我们有k次机会舍弃掉会要操作的次数较多的，其实就是保留n-k次操作次数少的
        int[][] tran = new int[10][10];// 分别表示s的位和t的位
        int[] count = new int[6];
        for (int i = 0; i < tran.length; i++) {
            for (int j = 0; j < tran[i].length; j++) {
                tran[i][j] = count(i, j);
            }
        }
        for (int i = 0; i < n; i++) {
            count[tran[s.charAt(i) - '0'][t.charAt(i) - '0']]++;
        }

        int left = n - k, res = 0, ind = 0;
        while (left > 0) {
            if (left < count[ind]) {
                res += left * ind;
                left = 0;
            } else {
                res += count[ind] * ind;
                left -= count[ind];

            }
            ind++;

        }
        return res;
    }

    public static int count(int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        return Math.min(a + 10 - b, b - a);
    }

    public static void main(String[] args) {

    }
}
