package Map;

import java.util.ArrayList;

public class Node {
    public int value;    //值
    public ArrayList<Node> nexts;    //相邻的节点
    public ArrayList<Edge> edges;    //相邻的边

    public Node(int value) {
        this.value = value;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
