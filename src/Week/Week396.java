package Week;

import java.util.*;

/**
 * @Author lty
 * @Date 2024/5/5 10:30
 * @Description
 */
public class Week396 {
    public boolean isValid(String word) {
        char[] charArray = word.toCharArray();
        if (charArray.length < 3) {
            return false;
        }
        boolean y = false, f = false;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] >= '0' && charArray[i] <= '9') {
                continue;
            }
            if (charArray[i] >= 'A' && charArray[i] <= 'z') {
                if (charArray[i] == 'a' || charArray[i] == 'e' || charArray[i] == 'i' || charArray[i] == 'o' || charArray[i] == 'u' || charArray[i] == 'A' || charArray[i] == 'E' || charArray[i] == 'I' || charArray[i] == 'O' || charArray[i] == 'U') {
                    y = true;

                } else {
                    f = true;
                }
                continue;
            }
            return false;
        }
        return y && f;
    }

    static class Node {
        char c;
        int time;
        HashMap<Character, Node> map;

        Node(char c) {
            this.c = c;
            this.time = 0;
            map = new HashMap<>();
        }


    }

    public static void insert(Node root, String s, int begin, int k) {
        if (k == 0) {
            return;
        }
        if (!root.map.containsKey(s.charAt(begin))) {
            root.map.put(s.charAt(begin), new Node(s.charAt(begin)));
        }
        root.map.get(s.charAt(begin)).time++;
        insert(root.map.get(s.charAt(begin)), s, begin + 1, k - 1);
    }

    public static int getTimes(Node root) {
        if (root.map.isEmpty()) {
            return root.time;
        }
        int max = 0;
        for (Node value : root.map.values()) {
            max = Math.max(max, getTimes(value));
        }
        return max;
    }

    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        Node root = new Node(' ');
        for (int i = 0; i < word.length(); i += k) {
            insert(root, word, i, k);
        }
        return word.length() / k - getTimes(root);
    }


    public static int minCostToEqualizeArray(int[] nums, int cost1, int cost2) {
        // 排序
        Arrays.sort(nums);
        long a = 0, b = 0;
        long cost = 0;
        int top = nums[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            if (a <= b) {
                a += top - nums[i];
            } else {
                b += top - nums[i];
            }
            if (cost2 >= 2 * cost1) {
                cost = (cost + a * cost1) % 1000000007;
                a = 0;
            } else {
                cost = (cost + Math.min(a, b) * cost2) % 1000000007;
                if (a >= b) {
                    a -= b;
                    b = 0;
                } else {
                    b -= a;
                    a = 0;
                }
            }
        }
        if ((nums.length - 1) * cost2 < (nums.length - 2) * cost1) {
            long n = Math.max(a, b);

            cost = (cost + n / (nums.length - 2) * (nums.length - 1) * cost2) % 1000000007;
            cost %= 1000000007;
            n = n % (nums.length - 2);
            if ((n + nums.length) % 2 == 0) {
                cost += Math.min(n * cost1 % 1000000007, (n + nums.length) / 2 * cost2 % 1000000007);
                cost %= 1000000007;
            } else {
                cost = (cost + n * cost1) % 1000000007;
            }


        } else {
            cost = (cost + Math.max(a, b) * cost1) % 1000000007;
        }
        return (int) cost;

    }

    public static void main(String[] args) {
        minCostToEqualizeArray(new int[]{4, 3, 1, 8}, 5, 1);
    }
}
