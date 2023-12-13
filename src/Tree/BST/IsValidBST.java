package Tree.BST;

import Tree.TreeNode;

/**
 * @Author 年年
 * @Date 2021/12/27 11:39
 * @Description 98. 验证二叉搜索树
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    public boolean dfs(TreeNode root, long maxValue, long minValue) {
        if (root == null) {
            return true;
        }
        if (root.val >= maxValue || root.val <= minValue) {
            return false;
        } else return dfs(root.left, root.val, minValue) && dfs(root.right, maxValue, root.val);
    }
}
