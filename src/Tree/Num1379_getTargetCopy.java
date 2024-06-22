package Tree;

/**
 * @Author lty
 * @Date 2024/4/3 12:47
 * @Description
 */
public class Num1379_getTargetCopy {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == target) {
            return cloned;
        }
        if (original == null) {
            return null;
        }
        TreeNode node = getTargetCopy(original.left, cloned.left, target);
        return node == null ? getTargetCopy(original.right, cloned.right, target) : node;
    }
}
