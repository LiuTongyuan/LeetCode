/**
 * @Author lty
 * @Date 2024/1/11 09:58
 * @Description 2645. 构造有效字符串的最少插入数
 */
public class Num2645_addMinimum {
    /**
     * ab bc ca 1 1 -2:  0
     * ac ba cb 2 -1 -1: 1
     * aa bb cc 0 0 0:   2
     *
     * @param word
     * @return
     */
    public int addMinimum(String word) {

        char[] charArray = word.toCharArray();
        int addMin = charArray[0] - 'a';
        for (int i = 1; i < charArray.length; i++) {
            addMin += (charArray[i] - charArray[i - 1] + 2) % 3;
        }
        addMin += 'c' - charArray[charArray.length - 1];
        return addMin;
    }
}
