package ���ֲ���;
/*
154. Ѱ����ת���������е���Сֵ II
��֪һ������Ϊ n �����飬Ԥ�Ȱ����������У����� 1 �� n �� ��ת �󣬵õ��������顣���磬ԭ���� nums = [0,1,4,4,5,6,7] �ڱ仯����ܵõ���
����ת 4 �Σ�����Եõ� [4,5,6,7,0,1,4]
����ת 7 �Σ�����Եõ� [0,1,4,4,5,6,7]
ע�⣬���� [a[0], a[1], a[2], ..., a[n-1]] ��תһ�� �Ľ��Ϊ���� [a[n-1], a[0], a[1], a[2], ..., a[n-2]] ��

����һ�����ܴ��� �ظ� Ԫ��ֵ������ nums ����ԭ����һ���������е����飬�����������ν����˶����ת�������ҳ������������е� ��СԪ�� ��



ʾ�� 1��

���룺nums = [1,3,5]
�����1
ʾ�� 2��

���룺nums = [2,2,2,0,1]
�����0


��ʾ��

n == nums.length
1 <= n <= 5000
-5000 <= nums[i] <= 5000
nums ԭ����һ��������������飬�������� 1 �� n ����ת


���ף�

������� Ѱ����ת���������е���Сֵ ��������Ŀ��
�����ظ���Ӱ���㷨��ʱ�临�Ӷ��𣿻����Ӱ�죬Ϊʲô��
 */
public class Q154���ظ�Ԫ�ص���ת������Сֵ {

    public int findMin(int[] nums) {
        return binarySearch1(nums, 0, nums.length - 1);
    }

    // ����1
    // ���ַ�����middle��ֵ�������Ҷ˵��ֵ�Ƚϡ�
    // ��С���Ҷ˵��ֵ��˵����Сֵ��pivot��ߣ������Ұ�����䡣
    // �������Ҷ˵��ֵ��˵����Сֵ��pivot�ұߣ������������䡣
    // �������Ҷ˵��ֵ�������ٿ��Խ��Ҷ˵���һ�������ȥ����
    private int binarySearch1(int[] nums, int start, int end){
        if (start == end)
            return nums[start];
        int middle = start + (end - start) / 2;

        if (nums[middle] < nums[end])
            return binarySearch1(nums, start, middle);
        else if (nums[middle] > nums[end])
            return binarySearch1(nums, middle + 1, end);
        else{
            return binarySearch1(nums, start, end - 1);
        }
    }

    // ����2
    // ����һ��������ͬ�ĵط����ڣ���pivot�����Ҷ˵��ֵ����˵���������߶��п��ܳ�����Сֵ��
    // ������ ���Ҷ����еݹ��ѯ�����ؽ�С�ߡ�
    private int binarySearch2(int[] nums, int start, int end){
        if (start == end)
            return nums[start];
        int middle = start + (end - start) / 2;

        if (nums[middle] < nums[end])
            return binarySearch2(nums, start, middle);
        else if (nums[middle] > nums[end])
            return binarySearch2(nums, middle + 1, end);
        else{
            return binarySearch2(nums, start, end - 1);
        }
    }


}
