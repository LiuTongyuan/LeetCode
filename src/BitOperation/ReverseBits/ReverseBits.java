package BitOperation.ReverseBits;

/**
 * @Author 年年
 * @Date 2021/12/23 8:53
 * @Description
 */
public class ReverseBits {
    public int reverseBits(int n) {
        n = ((n&0x55555555)<<1) | ((n>>>1)&0x55555555);
        n = ((n&0x33333333)<<2) | ((n>>>2)&0x33333333);
        n = ((n&0x0f0f0f0f)<<4) | ((n>>>4)&0x0f0f0f0f);
        n = ((n&0xff000000)>>>24) | ((n&0x00ff0000)>>>8) | ((n&0x0000ff00)<<8) | ((n&0x000000ff)<<24);
        return n;
    }
}
