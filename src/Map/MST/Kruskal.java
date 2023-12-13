package Map.MST;

import Map.*;

import java.util.*;

/*
5 8
1 4 9
1 3 15
1 2 3
2 3 2
2 5 200
3 4 7
3 5 14
4 5 16
1 0
2 3
3 5
4 9
5 19
*/
public class Kruskal {
    /**
     * 原理：按照边的大小顺序排列，依次选取最小的边，此边需满足加入后不构成环
     * 如何判断加入后是否形成环：并查集结构
     * <p>
     * 因为每次遍历边适用于边数较少的情况
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<Integer, Node> nodes = new HashMap<>(); //点
        TreeSet<Edge> edges = new TreeSet<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        }); //边

        int N = in.nextInt();
        int m = in.nextInt();
        for (int i = 0; i < N; i++) {
            /*节点编号为1-N*/
            nodes.put(i + 1, new Node(i + 1));
        }
        for (int i = 0; i < m; i++) {
            int from = in.nextInt();
            int to = in.nextInt();

            int weight = in.nextInt();
            /*此时读入的是双向边，单向边一次加入就行*/
            Node nodeFrom = nodes.get(from);
            Node nodeTo = nodes.get(to);
            nodeFrom.nexts.add(nodeTo);
            nodeTo.nexts.add(nodeFrom);
            nodeFrom.edges.add(new Edge(nodeFrom, nodeTo, weight));
            nodeTo.edges.add(new Edge(nodeTo, nodeFrom, weight));
            edges.add(new Edge(nodeFrom, nodeTo, weight));
            edges.add(new Edge(nodeTo, nodeFrom, weight));
        }

        HashSet<Edge> selectEdges = kruskal(nodes, edges);
        for (Edge edge : selectEdges) {
            System.out.println(edge.from.value + "-" + edge.to.value + ":" + edge.weight);
        }
    }

    public static HashSet<Edge> kruskal(HashMap<Integer, Node> nodes, TreeSet<Edge> edges) {
        Union<Node> union = new Union<>(nodes);
        HashSet<Edge> selectEdges = new HashSet<>();
        for (Edge edge : edges) {
            if (union.Find(edge.to) != union.Find(edge.from)) {
                union.union(edge.to, edge.from);
                selectEdges.add(edge);
            }
        }
        return selectEdges;
    }
}