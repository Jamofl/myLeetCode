package 位运算;
/*
https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/
剑指 Offer 65. 不用加减乘除做加法
写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。



示例:

输入: a = 1, b = 1
输出: 2


提示：

a, b 均可能是负数或 0
结果不会溢出 32 位整数
 */
public class Offer65位运算加法 {


    /*
        解法见
        https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/solution/mian-shi-ti-65-bu-yong-jia-jian-cheng-chu-zuo-ji-7/
        s = a + b -> n + c
        其中n为非进位和 c为进位
        n = a ^ b           异或
        c = (a & b) << 1    取and然后左移一位
     */
    public static void main(String[] args){
        int r = add(3,4);
        System.out.println(r);
    }

    // 递归法
    public int addRecursion(int a, int b) {
        if (a == 0 || b == 0)
            return a ^ b;    // 0 ^ n = n
        else
            return add(a ^ b, (a & b) << 1);
    }

    // 迭代法
    public static  int add(int a, int b) {
        while (a != 0 & b != 0){
            int n = a ^ b;
            int c = (a & b) << 1;
            a = n;
            b = c;
        }
        return a ^ b;
    }
}
