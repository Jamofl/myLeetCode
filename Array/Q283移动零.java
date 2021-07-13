/*
283. �ƶ���
����һ������ nums����дһ������������ 0 �ƶ��������ĩβ��ͬʱ���ַ���Ԫ�ص����˳��

ʾ��:

����: [0,1,0,3,12]
���: [1,3,12,0,0]
˵��:

������ԭ�����ϲ��������ܿ�����������顣
�������ٲ���������
ͨ������309,940�ύ����486,774
 */
package Array;

public class Q283�ƶ��� {


    // O(n2)
    // ���ú�ð���������Ƶ�˼·�����Ͻ�0���ð��
    public void moveZeroes(int[] nums) {
        int i = 0;
        int zeroCount = 0;
        for (int num : nums){
            if (num == 0)
                zeroCount ++;
        }

        while (i < nums.length - zeroCount){
            if (nums[i] == 0){
                for (int j = i; j <= nums.length - 2; j ++){
                    if (nums[j + 1] != 0){
                        swap(nums, j, j + 1);
                    }
                }
            }
            else
                i ++;
        }
    }

    // ˫ָ��
    // ���úͿ����������Ƶ�˼·�����Ͻ�iָ����ָ��0Ԫ�غ�jָ����ָ�ķ���Ԫ�ؽ��н���
    public void moveZeroes2(int[] nums) {
        int i = 0, j = 0;
        int n = nums.length;
        while (i <= j && j < n){
            if (nums[j] == 0) // jָ��Ԫ��Ϊ0,j ++
                j ++;
            else { // jָ��Ԫ�ز�Ϊ0
                if (nums[i] != 0){ // i ��Ϊ0, i ++, j ++
                    i ++;
                    j ++;
                }
                else { // i Ϊ0, j��Ϊ0 ����
                    swap(nums, i, j);
                    i ++;
                }
            }
        }
    }

    public void swap(int[] nums, int i, int j){
        if (i == j)
            return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {0, 0, 2};
        Q283�ƶ��� q = new Q283�ƶ���();
        q.moveZeroes(nums);
    }
}
