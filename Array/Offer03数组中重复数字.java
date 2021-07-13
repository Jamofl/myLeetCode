package Array;
/*
��ָ Offer 03. �������ظ�������
�ҳ��������ظ������֡�


��һ������Ϊ n ������ nums ����������ֶ��� 0��n-1 �ķ�Χ�ڡ�������ĳЩ�������ظ��ģ�����֪���м��������ظ��ˣ�Ҳ��֪��ÿ�������ظ��˼��Ρ����ҳ�����������һ���ظ������֡�

ʾ�� 1��

���룺
[2, 3, 1, 0, 2, 5, 3]
�����2 �� 3


���ƣ�

2 <= n <= 100000
 */
public class Offer03�������ظ����� {


    // �ٷ��ⷨ:
    // https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/solution/yuan-di-zhi-huan-shi-jian-kong-jian-100-by-derrick/
    /*
    ������ظ�Ԫ�أ����磺
 nums[i]     1  2  3  2    �ܲ�
     i       0  1  2  3    ��
ͬ���ģ�0�ſӲ�Ҫ1�ţ��Ⱥ�1�ſӽ����������������ģ�

 nums[i]     2  1  3  2    �ܲ�
     i       0  1  2  3    ��
0�ſӲ�Ҫ2���ܲ���ȥ��2�ſӽ����������������ģ�

 nums[i]     3  1  2  2    �ܲ�
     i       0  1  2  3    ��
0�ſӲ�Ҫ3���ܲ���ȥ��3�ſӽ����������������ģ�

 nums[i]     2  1  2  3    �ܲ�
     i       0  1  2  3    ��
0�ſӲ�Ҫ2���ܲ���ȥ��2�ſӽ��������������2�ſ�Ҳ��2���ܲ������һ��������ӣ�ͬʱҲ˵�����ظ�Ԫ�س��֡�
     */
    public int findRepeatNumber(int[] nums) {
        int i = 0;
        while (true){
            if (i == nums[i])
                i ++;
            else{
                if (nums[i] == nums[nums[i]])
                    return nums[i];
                else
                    swap(nums, i, nums[i]);
            }
        }
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
