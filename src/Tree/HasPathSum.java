package Tree;

/**
 * @Author 年年
 * @Date 2021/12/27 11:00
 * @Description 112. 路径总和
 * https://leetcode-cn.com/problems/path-sum/
 */
public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return dfs(root, targetSum, 0);
    }

    public boolean dfs(TreeNode root, int targetSum, int num) {
        if (root.left == null && root.right == null) {
            return num + root.val == targetSum;
        } else {
            if (root.left != null && dfs(root.left, targetSum, num + root.val)) {
                return true;
            }
            if (root.right != null && dfs(root.right, targetSum, num + root.val)) {
                return true;
            }
            return false;
        }
    }
}
