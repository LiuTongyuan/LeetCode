package Map;

public class Edge {
    public int weight;    //权值
    public Node from;    //出节点
    public Node to;        //入节点

    public Edge(Node from, Node to, int weight) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
