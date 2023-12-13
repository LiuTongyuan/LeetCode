package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 年年
 * @Date 2021/12/27 12:04
 * @Description 113. 路径总和 II
 * https://leetcode-cn.com/problems/path-sum-ii/
 */
public class PathSum {
    /**
     * 方法一：根本思想-回溯
     *
     * @param root
     * @param targetSum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if(root == null){
            return res;
        }else {
            dfs(root,res,path,targetSum,0);
            return res;
        }
    }

    public void dfs(TreeNode root, List<List<Integer>> res, List<Integer> path, int targetSum, int sum) {
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum + root.val == targetSum) {
                res.add(new ArrayList<>(path));
            }
        } else {
            if (root.left != null) {
                dfs(root.left, res, path, targetSum, sum + root.val);
            }
            if (root.right != null) {
                dfs(root.right, res, path, targetSum, sum + root.val);
            }
        }
        path.remove(path.size() - 1);
    }
}
