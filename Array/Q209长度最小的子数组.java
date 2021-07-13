/*
209. ������С��������
����һ������ n ���������������һ�������� target ��

�ҳ���������������� �� target �ĳ�����С�� ���������� [numsl, numsl+1, ..., numsr-1, numsr] ���������䳤�ȡ���������ڷ��������������飬���� 0 ��



ʾ�� 1��

���룺target = 7, nums = [2,3,1,2,4,3]
�����2
���ͣ������� [4,3] �Ǹ������µĳ�����С�������顣
ʾ�� 2��

���룺target = 4, nums = [1,4,4]
�����1
ʾ�� 3��

���룺target = 11, nums = [1,1,1,1,1,1,1,1]
�����0


��ʾ��

1 <= target <= 109
1 <= nums.length <= 105
1 <= nums[i] <= 105
 */
package Array;
import java.util.*;

public class Q209������С�������� {
    // �������ڷ�  ά������sum�洢��num[i] �� num[j]�ĺ�
    // ��� sum >= target : i ++ ; ������Сlen
    // ��� sum < target : j --
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0; int j = 0;
        int len = nums.length + 1;
        int sum = nums[0];
        while (true){
            if (sum >= target){
                len = Math.min(len, j - i + 1);
                sum = sum - nums[i];
                i ++;
            }
            else{
                j ++;
                if (j == nums.length)
                    break;
                sum = sum + nums[j];
            }
        }
        return (len == nums.length + 1) ? 0 : len;
    }

    public static void main(String[] args){
//        int r = Arrays.binarySearch(new int[]{1,2,3,4,5}, -2);
//        System.out.println(r);
        int[] temp = new int[] {1,2,3};
        int[] t = Arrays.copyOfRange(temp, 0, 1);

    }
}
