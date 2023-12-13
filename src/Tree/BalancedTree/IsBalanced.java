package Tree.BalancedTree;

import Tree.TreeNode;

/**
 * @Author 年年
 * @Date 2021/12/23 11:00
 * @Description 110. 平衡二叉树
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 */
public class IsBalanced {
    static class ReturnType {
        boolean isBalanced;
        int deepth;

        ReturnType(boolean isBalanced, int deepth) {
            this.deepth = deepth;
            this.isBalanced = isBalanced;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return dfs(root).isBalanced;
    }
    public ReturnType dfs(TreeNode root) {
        if (root == null){
            return new ReturnType(true,0);
        }
        ReturnType left = dfs(root.left);
        ReturnType right = dfs(root.right);
        return new ReturnType(left.isBalanced&&right.isBalanced&&(Math.abs(right.deepth-left.deepth)<=1),Math.max(left.deepth, right.deepth)+1);
    }
}
