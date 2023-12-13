package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BFSTraversal {
    public void bfs(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
        }
    }
}
