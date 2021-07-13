/*
240. ������ά���� II
��дһ����Ч���㷨������ m x n ���� matrix �е�һ��Ŀ��ֵ target ���þ�������������ԣ�

ÿ�е�Ԫ�ش������������С�
ÿ�е�Ԫ�ش��ϵ����������С�
 */
package Array;

public class Q240������ά����2 {

    // ����1  O(M + N)
    // ���ھ����е������е�����ȡ���½�Ԫ��Ϊ��ʼԪ�أ���target���ڸ�Ԫ�أ������ƶ�����targetС�ڸ�Ԫ�أ������ƶ��������ڣ�����
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0]. length;
        if (m == 0 || n == 0)
            return false;

        int i = m - 1;
        int j = 0;
        while (i >= 0 && j <= n - 1){
            if (target > matrix[i][j])
                j ++;
            else if (target < matrix[i][j])
                i --;
            else
                return true;
        }
        return false;
    }

    // ����2
    // ��ÿһ�н��ж��ֲ���  O(M LON(N))
    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i ++){
            if (target < matrix[i][0] || target > matrix[i][n - 1])
                continue;
            else{
                int re = binarySearch(matrix[i], target);
                if (re != -1)
                    return true;
            }
        }
        return false;
    }

    private int binarySearch(int[] nums, int target){
        int l = 0;
        int r = nums.length - 1;
        int middle;
        while (l <= r){
            middle = l + (r - l) / 2;
            if (target > nums[middle])
                l = middle + 1;
            else if (target < nums[middle])
                r = middle - 1;
            else
                return middle;
        }
        return -1;
    }

}
