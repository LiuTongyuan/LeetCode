package Tree;

import java.util.ArrayList;
import java.util.List;

public class MorrisTraversal {
    //Morris先序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
//            res.add(cur.val);不能直接遍历，会导致重复，因为有些点会来两次
            if (cur.left == null) {
                //此时没有左子树,先遍历cur,再进入右子树,可能是真的右子树,或者返回父亲节点
                res.add(cur.val);
                cur = cur.right;
            } else {
                //此时有左子树,找遍历时的上一个节点,它一定没有右孩子或者右孩子被我们修改为自己
                TreeNode pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }

                if (pre.right != cur) {
                    //没有右孩子,说明是第一次来到cur,先遍历cur,再使用pre存储一个到达cur的路径,然后进入cur的左子树
                    res.add(cur.val);
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    //有右孩子,说明是已经来到过cur,cur左子树已经遍历过了,
                    // 此时进入cur的右子树,可能指向真正的右子树,也可能是返回父亲节点
                    pre.right = null;
                    cur = cur.right;
                }
            }
        }
        return res;
    }

    //Morris中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                //没有左孩子则遍历自己
                res.add(cur.val);
                cur = cur.right;
            } else {
                //找遍历时的上一个节点，它一定没有右孩子或者右孩子被我们修改为自己
                TreeNode pre = root.left;
                while (pre.right != null && pre.right != root) {
                    pre = pre.right;
                }

                if (pre.right != cur) {
                    //没有右孩子，说明是第一次来到cur，不能遍历cur，使用pre存储一个到达cur的路径，然后进入cur的左子树
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    //有右孩子，说明是已经来到过cur，cur左子树已经遍历过了，此时遍历cur自己，
                    // 然后进入cur的右子树，可能指向真正的右子树，也可能是返回父亲节点
                    pre.right = null;
                    res.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return res;
    }
}
