/*
334. ��������Ԫ������
����һ���������� nums ���ж�����������Ƿ���ڳ���Ϊ 3 �ĵ��������С�

���������������Ԫ���±� (i, j, k) ������ i < j < k ��ʹ�� nums[i] < nums[j] < nums[k] ������ true �����򣬷��� false ��



ʾ�� 1��

���룺nums = [1,2,3,4,5]
�����true
���ͣ��κ� i < j < k ����Ԫ�鶼��������
ʾ�� 2��

���룺nums = [5,4,3,2,1]
�����false
���ͣ������������������Ԫ��
 */
package Array;
import java.util.*;
public class Q334��������Ԫ������ {

    // ����1 dp ���Ӷ�O (N2)
    // ��һ��dp���鱣��(0,i)������������󳤶ȣ���dp[i] >= 3��ѭ��������return true
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n <= 2)
            return false;

        int[] dp = new int[n]; // ��ʾ���������(��������)��������������
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i ++){
            for (int j = 0; j < i; j ++){
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                if (dp[i] >= 3)
                    return true;
            }
        }
        return false;
    }

    /*
    ����2
    �½�����������min���浱ǰΪֹ��Сֵ��mid���ֵ�ǰΪֹ�ڶ�Сֵ��
    �����ֱ�minС����ʱ������min��
    ������min ~ mid�м����ʱ������mid��
    �����ִ���mid����ʱ���ҵ��𰸣�
    ����ĵط������ڣ�������һ����minС����ʱ���ø���������min��ͬʱҲ˵����ǰ������һ������min��mid֮��������ڡ�
    ������������һ��max�������ֱ���ҵ���
     */
    public boolean increasingTriplet2(int[] nums) {
        int n = nums.length;
        if (n <= 2)
            return false;
        int min = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;

        for (int i = 0; i < n; i ++){
            if (nums[i] <= min)
                min = nums[i];
            else if (nums[i] <= mid)
                mid = nums[i];
            else
                return true;
        }
        return false;
    }


    /*
    ����3   ���α���  O��n��
    ʹ���������� mins[i] ��ʾ��0��i����СԪ��
               maxs[i] ��ʾ��i��n-1�����Ԫ��
    ������ mins[i] < nums[i] < maxs[i] ���������
     */
    public boolean increasingTriplet3(int[] nums) {
        int n = nums.length;
        if (n <= 2)
            return false;
        int[] mins = new int[n]; // minimum element from index 0 to i
        int[] maxs = new int[n]; // maximum element from index i to n - 1;
        LinkedList<Integer> q1 = new LinkedList<>();
        LinkedList<Integer> q2 = new LinkedList<>();
        for (int i = 0; i < n; i ++){
            increaseStackPush(q1, nums[i]);
            mins[i] = q1.getFirst();
        }

        for (int i = n - 1; i >= 0; i --){
            decreaseStackPush(q2, nums[i]);
            maxs[i] = q2.getFirst();
        }

        for (int i = 0; i < n; i ++){
            if (mins[i] < nums[i] && maxs[i] > nums[i])
                return true;
        }
        return false;
    }

    private void increaseStackPush(LinkedList<Integer> q, int num){
        while (q.size() != 0 && q.getLast() >= num)
            q.removeLast();
        q.add(num);
    }

    private void decreaseStackPush(LinkedList<Integer> q, int num){
        while (q.size() != 0 && q.getLast() <= num)
            q.removeLast();
        q.add(num);
    }
}
