/**
 * @Author lty
 * @Date 2024/4/10 14:36
 * @Description 1702. 修改后的最大二进制字符串
 */
public class Num1702_maximumBinaryString {

    /**
     * 00->10
     * 10->01
     * 可以得出，首先 1可以无条件右移，其次 最终的最大字符串一定只剩一个0，因为任意00可以变为10，01
     * 任意 0111...1110 可以变为 1011...1111
     * 题解变为最后找0的位置，0越靠右越好
     *
     * @param binary
     * @return
     */
    public static String maximumBinaryString(String binary) {
        char[] charArray = binary.toCharArray();
        int lastZero = -1;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '0') {
                if (lastZero == -1) {
                    lastZero = i;
                } else {
                    charArray[lastZero] = '1';
                    charArray[lastZero + 1] = '0';
                    if (i > lastZero + 1) {
                        charArray[i] = '1';
                    }
                    lastZero = lastZero + 1;
                }

            }
        }
        return new String(charArray);
    }

    /**
     * 所以可以数一共有多少0，只有一个的话，第一个0就是最后0的位置，每多一个0，最后的位置便右移一位。
     *
     * @param binary
     * @return
     */
    public static String maximumBinaryString2(String binary) {
        char[] charArray = binary.toCharArray();
        int lastZero = -1;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '0') {
                if (lastZero == -1) {
                    lastZero = i;
                } else {
                    lastZero++;
                }
                charArray[i] = '1';
            }
        }
        if (lastZero != -1) {
            charArray[lastZero] = '0';
        }
        return new String(charArray);
    }
}
