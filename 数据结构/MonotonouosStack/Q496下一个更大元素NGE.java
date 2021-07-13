/*
496. ��һ������Ԫ�� I
�������� û���ظ�Ԫ�� ������ nums1 �� nums2 ������nums1 �� nums2 ���Ӽ����ҵ� nums1 ��ÿ��Ԫ���� nums2 �е���һ��������ֵ��

nums1 ������ x ����һ������Ԫ����ָ x �� nums2 �ж�Ӧλ�õ��ұߵĵ�һ���� x ���Ԫ�ء���������ڣ���Ӧλ����� -1 ��



ʾ�� 1:

����: nums1 = [4,1,2], nums2 = [1,3,4,2].
���: [-1,3,-1]
����:
    ����num1�е�����4�����޷��ڵڶ����������ҵ���һ����������֣������� -1��
    ����num1�е�����1���ڶ�������������1�ұߵ���һ���ϴ������� 3��
    ����num1�е�����2���ڶ���������û����һ����������֣������� -1��
ʾ�� 2:

����: nums1 = [2,4], nums2 = [1,2,3,4].
���: [3,-1]
����:
    ���� num1 �е����� 2 ���ڶ��������е���һ���ϴ������� 3 ��
    ���� num1 �е����� 4 ���ڶ���������û����һ����������֣������� -1 ��


��ʾ��

nums1��nums2������Ԫ����Ψһ�ġ�
nums1��nums2 �������С��������1000��
 */
package ���ݽṹ.MonotonouosStack;
import java.util.*;

public class Q496��һ������Ԫ��NGE {
    /*
    Solution:
    ����nums2���飬����һ������ջ���ҵ�ÿ��Ԫ�ض�Ӧ��NGE��������Щ����洢��һ��hashmap�С�
    Ȼ�����hashmap���ҵ�nums1��ÿ��Ԫ�ص�NGE.
    ���У�Ѱ��NGE�Ĺ���Ϊ����nums[i] > stack.peek(), �򵯳�ջ��Ԫ�أ���������Ԫ�ص�NGE��Ϊnums[i];
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack();
        int[] ans = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap();
        for(int i = 0 ; i < nums2.length; i ++){
            while (stack.size() != 0 && stack.peek() < nums2[i])
                map.put(stack.pop(), nums2[i]);
            stack.push(nums2[i]);
        }

        for(int i = 0; i < nums1.length; i ++){
            ans[i] = map.getOrDefault(nums1[i], -1);
        }
        return ans;
    }
}
