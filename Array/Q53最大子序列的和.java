package Array;

public class Q53��������еĺ� {

    // ̰��
    // ��ǰsumΪ������sum���빱���У�sum + ��ǰnum
    // ��ǰsumΪ����������sum����sum����Ϊ��ǰnum
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int ans = nums[0];
        for (int num : nums){
            if (sum >= 0)
                sum = sum + num;
            else
                sum = num;
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    // ����
    // dp[i] = max(nums[i], nums[i] + dp[i - 1])
    public int maxSubArray2(int[] nums) {
        int n = nums.length;
        int ans = nums[0];
        int pre = nums[0];
        for (int i = 1; i < n; i ++){
            pre = Math.max(nums[i], nums[i] + pre);
            ans = Math.max(ans, pre);
        }
        return ans;
    }


}
