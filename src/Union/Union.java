package Union;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Union<K> {
    public Map<K, K> H;

    public Union(Map<Integer, K> nodes) {
        H = new HashMap<>();
        for (int num : nodes.keySet()) {
            H.put(nodes.get(num), nodes.get(num));
        }
    }

    /*此时的Find方法*/
    /*时间复杂度O(1)*/
    public K Find(K child) {
        // start记为出发点
        K start = child;
        while (child != H.get(child)) {
            child = H.get(child);
        }
        // 此时child是帮主
        // 我们再从出发点开始，把每个人的大哥改成帮主
        // 路径压缩的关键代码
        while (H.get(start) != child) {
            K next = H.get(start);
            H.put(start, child);
            start = next;
        }
        return child;
    }

    /*此时的union方法*/
    /*时间复杂度O(1)*/
    public void union(K A, K B) {
        K fatherOfA = Find(A);
        K fatherOfB = Find(B);
        H.put(fatherOfA, fatherOfB); // 成功将A所在帮派归入B帮派

    }
}