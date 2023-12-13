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
public class Prim {
    /**
     * 原理：从点入手，随机选取一个点作为初始点：
     * 每次选择最短的一条边，满足：from位于已选节点，to不位于已选节点
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<Integer, Node> nodes = new HashMap<>(); //点

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
//            edges.add(new Edge(nodeFrom, nodeTo, weight));
//            edges.add(new Edge(nodeTo, nodeFrom, weight));
        }
        HashSet<Edge> edges = prim(nodes, N);
//        for (Edge edge : edges) {
//            System.out.println(edge.from.value + "-" + edge.to.value + ":" + edge.weight);
//        }
    }

    public static HashSet<Edge> prim(HashMap<Integer, Node> nodes, int N) {
        TreeSet<Edge> edges = new TreeSet<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        }); //记录可选的边
        HashSet<Node> selectNodes = new HashSet<>();
        HashSet<Edge> selectEdges = new HashSet<>();
        Node bufNode = nodes.get(1);
        while (bufNode != null) {
            selectNodes.add(bufNode);
            edges.addAll(bufNode.edges);
            Edge selectEdge = selectRightEdge(edges, selectNodes);
            if (selectEdge != null) {
                selectEdges.add(selectEdge);
                System.out.println(selectEdge.from.value + "-" + selectEdge.to.value + ":" + selectEdge.weight);
            }
            bufNode = selectEdge == null ? null : selectEdge.to;
        }
        return selectEdges;
    }

    public static Edge selectRightEdge(TreeSet<Edge> edges, HashSet<Node> selectNode) {
        for (Edge edge : edges) {
            if (selectNode.contains(edge.from) && !selectNode.contains(edge.to)) {
                edges.remove(edge);
                return edge;
            }
        }
        return null;
    }
}
