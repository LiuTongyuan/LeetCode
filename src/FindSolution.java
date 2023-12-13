// import java.util.ArrayList;
// import java.util.List;
//
// /**
//  * @Author lty
//  * @Date 2023/2/18 09:09
//  * @Description 1237. 找出给定方程的正整数解
//  * https://leetcode.cn/problems/find-positive-integer-solution-for-a-given-equation/
//  */
// public class FindSolution {
//     /**
//      * 解题思路：二分查找，限制y的最大值，每次x+1
//      * 在x和y的变化过程中就不需要再使用二分查找了，已经够快了
//      *
//      * @param customfunction:未知函数
//      * @param z：目标值
//      * @return
//      */
//     public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
//         List<List<Integer>> res = new ArrayList<List<Integer>>();
//         for (int x = 1, y = 1000; x <= 1000 && y >= 1; x++) {
//             while (y >= 1 && customfunction.f(x, y) > z) {
//                 y--;
//             }
//             if (y >= 1 && customfunction.f(x, y) == z) {
//                 List<Integer> pair = new ArrayList<Integer>();
//                 pair.add(x);
//                 pair.add(y);
//                 res.add(pair);
//             }
//         }
//         return res;
//     }
// }
