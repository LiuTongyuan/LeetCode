package Tree;

/**
 * @Author 年年
 * @Date 2021/12/27 10:53
 * @Description 129. 求根节点到叶节点数字之和
 * https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 */
public class SumNumbers {

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root,0);
    }

    public int dfs(TreeNode root, int num) {
        if (root.left == null && root.right == null) {
            return num * 10 + root.val;
        } else {
            int sum = 0;
            if (root.left != null) {
                sum += dfs(root.left, num * 10 + root.val);
            }
            if (root.right != null) {
                sum += dfs(root.right, num * 10 + root.val);
            }
            return sum;
        }
    }
}
