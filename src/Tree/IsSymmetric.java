package Tree;

/**
 * @Author 年年
 * @Date 2021/12/27 11:48
 * @Description 101. 对称二叉树
 * https://leetcode-cn.com/problems/symmetric-tree/
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return dfs(root.left,root.right);
    }

    public boolean dfs(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 != null && root2 != null && root1.val == root2.val) {
            return dfs(root1.left,root2.right)&&dfs(root1.right,root2.left);
        } else {
            return false;
        }
    }
}
