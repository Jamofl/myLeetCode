package Array;
/*
628. �����������˻�
����һ���������� nums �����������ҳ�����������ɵ����˻������������˻���

ʾ�� 1��

���룺nums = [1,2,3]
�����6
ʾ�� 2��

���룺nums = [1,2,3,4]
�����24
ʾ�� 3��

���룺nums = [-1,-2,-3]
�����-6


��ʾ��

3 <= nums.length <= 104
-1000 <= nums[i] <= 1000
 */
import java.util.*;
public class Q628�������ֵ����˻� {


    /*
      ��ѧ�ķ���:  ���Ƚ������ź���
      ��ȫΪ��������ȫΪ���������������������˻���һ������������Ԫ����ˡ�
      �������������棬�������������˻���Ϊ max(��С�������� ���� �����Ǹ����� ��������Ԫ�����)
     */

    // ����1: ����Ȼ��ȡ ���������� �� ��С��������  O(NLogN)
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        return Math.max(nums[n - 1] * nums[n - 2] * nums[n - 3], nums[0] * nums[1] * nums[n - 1]);
    }

    // ����2: ֱ��һ������������������������Ԫ�غ���С������Ԫ�� O(N)
    public int maximumProduct2(int[] nums) {
        int n = nums.length;
        int firstMax = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE, thirdMax = Integer.MIN_VALUE;
        int firstMin = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for (int i = 0; i < n; i ++){
            if (nums[i] < firstMin){
                secondMin = firstMin;
                firstMin = nums[i];
            }
            else if (nums[i] < secondMin)
                secondMin = nums[i];

            if (nums[i] > firstMax){
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = nums[i];
            }
            else if (nums[i] > secondMax){
                thirdMax = secondMax;
                secondMax = nums[i];
            }
            else if (nums[i] > thirdMax)
                thirdMax = nums[i];
        }
        return Math.max(firstMax * secondMax * thirdMax,  firstMin * secondMin * firstMax);
    }
}
