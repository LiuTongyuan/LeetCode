package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author lty
 * @Date 2024/4/2 12:32
 * @Description
 */
public class Num894_allPossibleFBT {
    public static HashMap<Integer, ArrayList> hashMap = new HashMap<>();
    static {
        ArrayList list = new ArrayList();
        list.add(new TreeNode());
        hashMap.put(1, list);
    }

    public List<TreeNode> allPossibleFBT(int n) {
        if (hashMap.containsKey(n)) {
            return hashMap.get(n);
        }
        ArrayList<TreeNode> arrayList = new ArrayList();
        hashMap.put(n,arrayList);
        if (n % 2 == 0) {
            return arrayList;
        }
        for (int i = 1; i < n; i+=2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(n - 1 - i);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    arrayList.add(new TreeNode(0, l,r));
                }
            }
        }
        return arrayList;
    }
}
