package Week;

import java.util.ArrayList;

/**
 * @Author lty
 * @Date 2024/4/21 20:03
 * @Description
 */
public class New4_21 {



    /**
     * 输入n,k，问将数字n分成k份，有多少中分法。输出分法。n(6,200],k[2,6]
     * 示例：输入：n=7，k=3
     * 输出4
     * 分法：
     * 1，1，5，
     * 1，2，4，
     * 1，3，3，
     * 2，2，3
     *
     * @param n
     * @param k
     */
    public static ArrayList<ArrayList<Integer>> one(int n, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        path.add(1);
        dfs(res, path, n, k);
        return res;
    }

    public static void dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> path, int n, int k) {
        if (k == 0 ) {
            if(n == 0){
                res.add((ArrayList<Integer>) path.clone());
            }
            return;
        }
        for (int i = path.get(path.size() - 1); i <= n / k; i++) {
            path.add(i);
            dfs(res, path, n - i, k - 1);
            path.remove(path.size() - 1);
        }

    }

    public static void main(String[] args) {
        one(7, 3);
    }
}
