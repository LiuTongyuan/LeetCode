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
public class SPFA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<Integer, Node> nodes = new HashMap<>(); //点

        int N = in.nextInt();
        int m = in.nextInt();

        for (int i = 0; i < N; i++) {
            /*节点编号为1-Week396*/
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

        Map<Node, Integer> distance = SPFA(nodes, N);
        for (Integer num : nodes.keySet()) {
            System.out.println(num + " " + distance.get(nodes.get(num)));
        }
    }

    public static Map<Node, Integer> SPFA(HashMap<Integer, Node> nodes, int N) {
        Map<Node, Integer> distance = new HashMap<>();
        distance.put(nodes.get(1), 0);
        for (int i = 1; i < N; i++) {
            distance.put(nodes.get(i + 1), Integer.MAX_VALUE);
        }

        Queue<Node> queue = new LinkedList<>();
        Node bufNode = nodes.get(1);
        while (bufNode != null) {
            for (Edge edge : bufNode.edges) {
                if (distance.get(bufNode) + edge.weight < distance.get(edge.to)) {
                    distance.put(edge.to, distance.get(bufNode) + edge.weight);
                    if (!queue.contains(edge.to)) {
                        queue.add(edge.to);
                    }
                }
            }
            bufNode = queue.poll();
        }
        return distance;
    }
}
