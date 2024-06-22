import javax.tools.Diagnostic;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author lty
 * @Date 2024/4/7 09:56
 * @Description 1600. 王位继承顺序
 */
public class Num1600_ThroneInheritance {
    private Node root;

    private class Node {
        String name;
        Node par;
        List<Node> children;
        boolean hasDead;

        Node(Node par, String name) {
            this.par = par;
            this.name = name;
            this.children = new ArrayList<>();
            this.hasDead = false;
        }

        void addChild(String name) {
            children.add(new Node(this, name));
        }

        void dead() {
            this.hasDead = true;
        }

        boolean hasDead() {
            return this.hasDead;
        }
    }

    Node find(Node root, String name) {
        if (root == null || root.name.equals(name)) {
            return root;
        }
        for (Node child : root.children) {
            Node res = find(child, name);
            if (res != null) {
                return res;
            }
        }
        return null;
    }

    void tra(Node root, List<String> res) {
        if (root == null) {
            return;
        }
        if (!root.hasDead()){
            res.add(root.name);
        }

        for (Node child : root.children) {
            tra(child, res);
        }
    }

    public Num1600_ThroneInheritance(String kingName) {
        root = new Node(null, kingName);
    }

    public void birth(String parentName, String childName) {
        Node par = find(root, parentName);
        par.addChild(childName);
    }

    public void death(String name) {
        Node cur = find(root, name);
        cur.dead();
    }

    public List<String> getInheritanceOrder() {
        ArrayList<String> res = new ArrayList<>();
        tra(root, res);
        return res;
    }
}
