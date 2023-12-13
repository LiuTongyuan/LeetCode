package DP.Rob;

import Tree.TreeNode;

/**
 * @Author 年年
 * @Date 2021/12/17 9:35
 * @Description LeetCode-337:打家劫舍 III
 * https://leetcode-cn.com/problems/house-robber-iii/
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。
 * 这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。
 * 一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连
 * 的房子在同一天晚上被打劫，房屋将自动报警。
 * <p>
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 */
public class Rob3 {
    /**
     * 本质：树形dp问题，向子树要答案
     * rob代表本节点被抢所能带来的最大收益
     * notRob代表本节点不被抢带来的最大收益
     * 递推公式：
     * ReturnType leftReturn = dp(root.left);
     * ReturnType rightReturn = dp(root.right);
     * //本节点被抢代表子节点不能被抢
     * root.rob = root.val + leftReturn.notRob + rightReturn.notRob;
     * //本节点不被抢代表子节点可以抢也可以不抢
     * root.notRob = Math.max(leftReturn.rob, leftReturn.notRob) + Math.max(rightReturn.rob, rightReturn.notRob)
     */
    static class ReturnType {
        int rob;
        int notRob;

        ReturnType(int rob, int notRob) {
            this.rob = rob;
            this.notRob = notRob;
        }
    }

    public int rob(TreeNode root) {
        ReturnType dp = dp(root);
        return Math.max(dp.rob, dp.notRob);
    }

    public ReturnType dp(TreeNode root) {
        if (root == null) {
            return new ReturnType(0, 0);
        }
        ReturnType leftReturn = dp(root.left);
        ReturnType rightReturn = dp(root.right);
        return new ReturnType(root.val + leftReturn.notRob + rightReturn.notRob,
                Math.max(leftReturn.rob, leftReturn.notRob) + Math.max(rightReturn.rob, rightReturn.notRob));
    }
}
