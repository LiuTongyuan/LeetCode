package Map.SPA;

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

public class Dijkstra {
    /**
     * 原理：
     * 1：每次从剩余未确认最短距离的点中选择一个距离源节点最短的点:
     * 2：利用该节点的距离关系更新其他未选择节点到源节点的距离关系
     *
     * 适用范围：边权值不为负
     */
    /**
     * 伪代码：
     * 1：读入所有的点和边信息
     * 2：初始化源节点到其他节点的距离为Integer.MAX_VALUE
     * 3：创建一个
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<Integer, Node> nodes = new HashMap<>(); //点
        int N = in.nextInt();
        int m = in.nextInt();
        for (int i = 0; i < N; i++) {
            /*节点编号为1-N*/
            nodes.put(i + 1, new Node(0));
        }
        for (int i = 0; i < m; i++) {
            int from = in.nextInt();
            int to = in.nextInt();

            int weight = in.nextInt();
            Node nodeFrom = nodes.get(from);
            Node nodeTo = nodes.get(to);
            /*此时读入的是双向边，单向边一次加入就行*/
            nodeFrom.nexts.add(nodeTo);
            nodeTo.nexts.add(nodeFrom);
            nodeFrom.nexts.add(nodeTo);
            nodeTo.nexts.add(nodeFrom);
            nodeFrom.edges.add(new Edge(nodeFrom, nodeTo, weight));
            nodeTo.edges.add(new Edge(nodeTo, nodeFrom, weight));
//            edges.add(new Prim.Edge(nodeFrom, nodeTo, weight));
//            edges.add(new Prim.Edge(nodeTo, nodeFrom, weight));
        }
        HashMap<Node, Integer> distance = dijkstra(nodes, N);
        for (Integer num : nodes.keySet()) {
            System.out.println(num + " " + distance.get(nodes.get(num)));
        }
    }

    public static HashMap<Node, Integer> dijkstra(HashMap<Integer, Node> nodes, int N) {
        HashSet<Node> selectNodes = new HashSet<>(); //记录已经确认最短距离的点
        HashMap<Node, Integer> distance = new HashMap<>(); //记录源节点到其他节点之间的距离
        //初始化距离
        distance.put(nodes.get(1), 0);
        for (int i = 1; i < N; i++) {
            distance.put(nodes.get(i + 1), Integer.MAX_VALUE);
        }
        Node bufNode = selectNodeMinWithDishtance(distance, selectNodes);
        while (bufNode != null) {
            selectNodes.add(bufNode);
            for (Edge edge : bufNode.edges) {
                Node to = edge.to;
                int bufNodeDistance = distance.get(bufNode);
                int nodeToDistance = distance.get(to);
                distance.put(to, Math.min(nodeToDistance, bufNodeDistance + edge.weight));
            }
            bufNode = selectNodeMinWithDishtance(distance, selectNodes);
        }
        return distance;
    }

    public static Node selectNodeMinWithDishtance(HashMap<Node, Integer> distance, HashSet<Node> selectNodes) {
        Node minNode = null;
        int minDis = Integer.MAX_VALUE;
        for (Node temp : distance.keySet()) {
            if (!selectNodes.contains(temp) && minDis > distance.get(temp)) {
                minNode = temp;
                minDis = distance.get(temp);
            }
        }
        return minNode;
    }
}
