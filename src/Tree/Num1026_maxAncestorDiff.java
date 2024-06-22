package Tree;

/**
 * @Author lty
 * @Date 2024/4/5 19:38
 * @Description
 */
public class Num1026_maxAncestorDiff {

    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    public static int dfs(TreeNode root, int maxPar, int minPar) {
        if (root == null) {
            return 0;
        }
        int max = Math.max(root.val, maxPar);
        int min = Math.min(root.val, minPar);

        return Math.max(Math.max(dfs(root.left, max,min), dfs(root.right, max,min)), Math.max(Math.abs(maxPar - root.val),Math.abs(minPar - root.val)));
    }
}
