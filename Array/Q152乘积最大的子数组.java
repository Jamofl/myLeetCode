/*
152. �˻����������
����һ���������� nums �������ҳ������г˻��������������飨�������������ٰ���һ�����֣��������ظ�����������Ӧ�ĳ˻���



ʾ�� 1:

����: [2,3,-2,4]
���: 6
����: ������ [2,3] �����˻� 6��
ʾ�� 2:

����: [-2,0,-1]
���: 0
����: �������Ϊ 2, ��Ϊ [-2,-1] ���������顣
 */
package Array;

public class Q152�˻����������� {

    // ǰ׺��ö��  O(n2) : ��������ѭ�����������Ӷ�ΪO(n2)�� ͨ��ǰ׺�ͼ���˻������˻�����ĸ��ӶȽ�άO��1��
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int ans = 1;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i ++){
            ans = 1;
            for (int j = i; j < n; j ++){
                ans = ans * nums[j];
                max = Math.max(max, ans);
            }
        }
        return max;
    }

    // ��̬�滮
    // ���ڳ˷����������ԣ��޷�ֱ�Ӹ��� dp[i] = max(nums[i], nums[i] * dp[i - 1])���ж�����Ϊ�˷���ֹ��ǰһ�����йأ����������й�
    // ��ά����������dpMax dpMin, �ֱ��¼��ĿǰΪֹ�����˻�����С�˻�;
    // ��nums[i]Ϊ����ʱ��������Ҫ������һ�����˻�����nums[i]Ϊ����ʱ��������Ҫ��һ����С�˻�;
    // ���շ���dpMax�������Ǹ�����
    public int maxProduct2(int[] nums) {
        int n = nums.length;
        int[] dpMax = new int[n];
        int[] dpMin = new int[n];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        int ans = dpMax[0];
        for (int i = 1; i < n; i ++){
            dpMax[i] = Math.max(nums[i], Math.max(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]));
            dpMin[i] = Math.min(nums[i], Math.min(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]));
            ans = Math.max(ans, dpMax[i]);
        }
        return ans;
    }

    // dp �ռ临�ӶȽ���ΪO��1) ����Ҫʹ���ĸ���������
    public int maxProduct3(int[] nums) {
        int n = nums.length;
        int PreMax = nums[0];
        int PreMin = nums[0];
        int ans = nums[0];
        for (int i = 1; i < n; i ++){
            // ��Ҫ����������������浱ǰ��ֵ��ͬ�����и��¡�
            int Max = Math.max(nums[i], Math.max(PreMax * nums[i], PreMin * nums[i]));
            int Min = Math.min(nums[i], Math.min(PreMax * nums[i], PreMin * nums[i]));
            ans = Math.max(ans, Max);
            PreMax = Max;
            PreMin = Min;
        }
        return ans;
    }

    public static void main(String[] args){
        Q152�˻����������� q = new Q152�˻�����������();
        int r = q.maxProduct3(new int[] {-4, -3, -2});
        System.out.println(r);

    }
}
