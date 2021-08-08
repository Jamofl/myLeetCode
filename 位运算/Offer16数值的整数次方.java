package 位运算;

/*
https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
剑指 Offer 16. 数值的整数次方
实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。



示例 1：

输入：x = 2.00000, n = 10
输出：1024.00000
示例 2：

输入：x = 2.10000, n = 3
输出：9.26100
示例 3：

输入：x = 2.00000, n = -2
输出：0.25000
解释：2-2 = 1/22 = 1/4 = 0.25
 */
public class Offer16数值的整数次方 {

    /*
    // 方法1： 备忘录的递归解法， n 为偶数，x ^ n = (x ^ (n/ 2))2
    //                         n 为奇数，x ^ n = (x ^ (n/ 2))2 * x;
    // 但是当n = 2 ^ 31 - 1，n + 1会溢出，无法使用备忘录的方式
    public double[] cache;
    public double myPow(double x, int N) {
        cache = new double[Math.abs(N)];
        if (N < 0){
            return calRec(1 / x, -N);
        }
        return calRec(x, N);
    }

    private double cal(double x, int n){
        double r = 1;
        while (n > 0){
            r = r * x;
            n --;
        }
        return r;
    }

    private double calRec(double x, int n){
        if (cache[n] != 0)
            return cache[n];

        else if (n == 0)
            cache[n] = 1;
        else if (n == 1)
            cache[n] = x;
        else if (n == 2)
            cache[n] = x * x;
        else if (n % 2 == 0)
            cache[n] = calRec(x, n / 2) * calRec(x, n / 2);
        else
            cache[n] = calRec(x, n / 2) * calRec(x, n - (n / 2));
        return cache[n];
    }
     */

    /*
    方法2 位运算  将n表示成2的幂次  如2 ^ 7 = 2 ^ (111) = (2 ^ 4) * (2 ^ 2) * (2 ^ 1)
     */
    public double myPow(double x, int n) {
        long b = n;
        if (b < 0)
            return myPowHelper(1 / x, - b);
        return myPowHelper(x, b);
    }

    public double myPowHelper(double x, long n) {
        double re = 1;
        while (n > 0){
            if ((n & 1) != 0){  // 说明这一位为1，需要乘以2的幂次
                re = re * x;
            }
            x = x * x;
            n = n >> 1;

        }
        return re;
    }



    public static void main(String[] args) {
        Offer16数值的整数次方 Q = new Offer16数值的整数次方();
        double r = Q.myPow(2.0, 4);
        System.out.println(r);
    }
}
