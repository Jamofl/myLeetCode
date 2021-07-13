package 位运算;

/**
 * https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/submissions/
 */
public class Offer15二进制中1的个数 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        int m = 0;
        for (int i = 0; i < 32; i ++){
            m = n >>> i;
            if ((m & 1) != 0)
                count ++;
        }
        return count;
    }
}
