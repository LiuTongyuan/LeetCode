package Tree;

/**
 * @Author lty
 * @Date 2023/2/3 13:46
 * @Description
 */
public class BTreeGameWinningMove {
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode XNode = findX(root, x);
        int numOfXLeft = count(XNode.left);
        int numOfXRight = count(XNode.right);
        int numOfXParent = n - numOfXLeft - numOfXRight - 1;
        int maxY = Math.max(numOfXParent, Math.max(numOfXLeft, numOfXRight));
        return maxY > n - maxY;
    }

    public TreeNode findX(TreeNode root, int x) {
        if (root == null || root.val == x){
            return root;
        } else {
            TreeNode res = findX(root.left, x);
            if (res != null) {
                return res;
            } else {
                return findX(root.right, x);
            }
        }
    }

    public int count(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return count(root.left) + count(root.right) + 1;
        }
    }
}
