package ���ֲ���;
/*
153. Ѱ����ת���������е���Сֵ
��֪һ������Ϊ n �����飬Ԥ�Ȱ����������У����� 1 �� n �� ��ת �󣬵õ��������顣���磬ԭ���� nums = [0,1,2,4,5,6,7] �ڱ仯����ܵõ���
����ת 4 �Σ�����Եõ� [4,5,6,7,0,1,2]
����ת 7 �Σ�����Եõ� [0,1,2,4,5,6,7]
ע�⣬���� [a[0], a[1], a[2], ..., a[n-1]] ��תһ�� �Ľ��Ϊ���� [a[n-1], a[0], a[1], a[2], ..., a[n-2]] ��

����һ��Ԫ��ֵ ������ͬ ������ nums ����ԭ����һ���������е����飬�����������ν����˶����ת�������ҳ������������е� ��СԪ�� ��

ʾ�� 1��

���룺nums = [3,4,5,1,2]
�����1
���ͣ�ԭ����Ϊ [1,2,3,4,5] ����ת 3 �εõ��������顣
ʾ�� 2��

���룺nums = [4,5,6,7,0,1,2]
�����0
���ͣ�ԭ����Ϊ [0,1,2,4,5,6,7] ����ת 4 �εõ��������顣
ʾ�� 3��

���룺nums = [11,13,15,17]
�����11
���ͣ�ԭ����Ϊ [11,13,15,17] ����ת 4 �εõ��������顣

��ʾ��
n == nums.length
1 <= n <= 5000
-5000 <= nums[i] <= 5000
nums �е��������� ������ͬ
nums ԭ����һ��������������飬�������� 1 �� n ����ת
 */
public class Q153��ת������Сֵ {
    public int findMin(int[] nums) {
        return binarySearch3(nums, 0, nums.length - 1);

    }


    // ��ʼ�汾 ���ǵ�����϶� �ϸ���
    private int binarySearch(int[] nums){
        int start = 0;
        int end = nums.length - 1;
        int middle = start + (end - start) / 2;

        while (start <= end){
            if (start == end)
                return nums[start];
            else if (start == end - 1)
                return Math.min(nums[start], nums[end]);

            middle = start + (end - start) / 2;
            if (nums[start] < nums[middle] && nums[middle] < nums[end]) // a < b < c �����
                end = middle - 1;   // ����ȡ��middle
            else if (nums[middle] < nums[end] && nums[end] < nums[start]) // b < c < a �����
                end = middle;       // ����ȡ��middle
            else if (nums[end] < nums[start] && nums[start] < nums[middle]) // c < a < b �ұ���
                start = middle + 1; // ����ȡ��middle
        }
        return -1;
    }

    // ��� �����汾
    // ���ַ�����middle��ֵ�������Ҷ˵��ֵ�Ƚϡ�
    // ��С���Ҷ˵��ֵ��˵����Сֵ��pivot��ߣ������Ұ�����䡣
    // �������Ҷ˵��ֵ��˵����Сֵ��pivot�ұߣ������������䡣
    private int binarySearch2(int[] nums){
        int start = 0;
        int end = nums.length - 1;
        int middle;

        while (start < end){
            middle = start + (end - start) / 2;
            if (nums[middle] < nums[end])
                end = middle;
            else if (nums[middle] > nums[end])
                start = middle + 1;
        }
        return nums[start];
    }

    // ��� �ݹ�汾
    private int binarySearch3(int[] nums, int start, int end){
        if (start == end)
            return nums[start];
        int middle = start + (end - start) / 2;
        if (nums[middle] < nums[end])
            return binarySearch3(nums, start, middle);
        else if (nums[middle] > nums[end])
            return binarySearch3(nums, middle + 1, end);
        return -1;
    }



    public static void main(String[] args){
        Q153��ת������Сֵ q = new Q153��ת������Сֵ();
        int r = q.findMin(new int[] {3,4,5,1,2});
        System.out.println(r);
    }
}
