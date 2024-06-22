/**
 * @Author lty
 * @Date 2024/1/2 13:12
 * @Description 466. 统计重复个数
 * 循环节
 */
public class Num466_getMaxRepetitions {
    // public static void main(String[] args) {
    //     new Num466_getMaxRepetitions().getMaxRepetitions("ecbafedcba", 4, "abcdef", 1);
    // }

    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        return m2(s1, n1, s2, n2);
    }


    // 暴力解法，会超时
    public int m1(String s1, int n1, String s2, int n2) {
        int p1 = 0, p2 = 0;
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        while (p1 < arr1.length * n1) {
            p1 = searchOne(arr1, n1, arr2, p1);
            if (p1 == 0) {
                break;
            }
            p2++;

        }
        return p2 / n2;
    }

    /**
     * 找循环节
     * 下面i位置全部为当前指针对 s1.length取模得到的位置；
     * 如果有周期 k*s1.length 恰出现（这个周期的最后一位得与s2的最后一位匹配） n 个 s2 那么，就可以简化计算
     * 为什么足够大时一定会有周期！
     * 假设使用count[i] 记录以i 为开始匹配一次 s2 后的下一次开始位置，那么从任意一个位置进入，最后一定会进入环（n个点，n条边）
     * 我们需要的就是找出这个环！
     * 利用数组记录上次以i位置开始 前 匹配的个数
     *
     * @param s1
     * @param n1
     * @param s2
     * @param n2
     * @return
     */
    public int m2(String s1, int n1, String s2, int n2) {
        // 从每个位置开始往后多少字符可以匹配一次s2
        int p1 = 0, p2 = 0;
        int[][] count = new int[s1.length()][2];
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        while (p1 < arr1.length * n1) {
            p1 = searchOne(arr1, n1, arr2, p1);
            if (p1 == 0) {
                break;
            } else {
                p2++;
                if (count[p1 % arr1.length][0] != 0) {
                    //     找到了循环节 count[p1 % arr1.length][0]
                    int loop = p1 - count[p1 % arr1.length][0];
                    int num = p2 - count[p1 % arr1.length][1];
                    p2 += (arr1.length * n1 - p1) / loop * num;
                    p1 += (arr1.length * n1 - p1) / loop * loop;
                    while (p1 < arr1.length * n1) {
                        p1 = searchOne(arr1, n1, arr2, p1);
                        if (p1 == 0) {
                            break;
                        }
                        p2++;

                    }
                    break;
                } else {
                    count[p1 % arr1.length][0] = p1;
                    count[p1 % arr1.length][1] = p2;
                }
            }
        }

        return p2 / n2;
    }

    public int searchOne(char[] arr1, int n1, char[] arr2, int start) {
        int count = 0;
        while (start < arr1.length * n1 && count < arr2.length) {
            if (arr1[start % arr1.length] == arr2[count]) {
                count++;
            }
            start++;
        }
        return count == arr2.length ? start : 0;
    }
}
