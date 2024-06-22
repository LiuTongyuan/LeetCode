package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author lty
 * @Date 2024/4/9 13:54
 * @Description 1483. 树节点的第 K 个祖先
 * 重要思路倍增（每个元素分别记录第2^0,2^1,...2^n个祖先结点）
 */
public class Num1483_TreeAncestor {
    private int[][] parent;
    private final int LEN = 16;


    public Num1483_TreeAncestor(int n, int[] parent) {
        this.parent = new int[n][LEN];
        for (int i = 0; i < parent.length; i++) {
            Arrays.fill(this.parent[i], -2);// 标记为未初始化
            this.parent[i][0] = parent[i];
        }
    }

    public int getKthAncestor(int node, int k) {
        if (k == 0 || node == -1) {
            return node;
        }
        if (parent[node][getHighOne(k)] == -2) {
            init(node);
        }
        return getKthAncestor(parent[node][getHighOne(k)], k - (1 << getHighOne(k)));
    }

    private void init(int node) {
        int par = parent[node][0];
        for (int i = 1; i < parent[node].length; i++) {
            if (parent[node][i - 1] == -1) {
                parent[node][i] = -1;
            } else {
                if (parent[parent[node][i - 1]][i - 1] == -2) {
                    init(parent[node][i - 1]);
                }
                parent[node][i] = parent[parent[node][i - 1]][i - 1];
            }
        }
    }

    public int getHighOne(int k) {
        int count = -1;
        while (k > 0) {
            k = k >> 1;
            count++;
        }
        return count;
    }
}

