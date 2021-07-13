package 动态规划;

public class Offer14剪绳子 {
    public static int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i ++){
            for (int j = 1; j <= i / 2; j ++){
                int n1 = Math.max(j, dp[j]);
                int n2 = Math.max(i - j, dp[i - j]);
                dp[i] = Math.max(dp[i], n1 * n2);
            }
        }
        return dp[n];
    }

    public static void main(String[] args)
    {
        int r = cuttingRope(2);
        System.out.println(r);
    }
}
