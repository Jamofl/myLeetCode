/*
74. ������ά����
��дһ����Ч���㷨���ж� m x n �����У��Ƿ����һ��Ŀ��ֵ���þ�������������ԣ�

ÿ���е����������Ұ��������С�
ÿ�еĵ�һ����������ǰһ�е����һ��������
 */
package Array;

public class Q74��ά�������� {

    /*
    O(LOG(M * N))
    �Ѹþ��󵱳�һ�������һά����������������ʱ�����±��ת���� x = i * n + j;
    �Ƴ� i = x / n; j = x % n;

    public int m;
    public int n;
    public boolean searchMatrix(int[][] matrix, int target) {
        m = matrix.length;
        n = matrix[0].length;
        return (binarySearch(matrix, target) == -1) ? false : true;

    }

    public int binarySearch(int[][] matrix, int target){
        int l = 0;
        int r = m * n - 1;
        while (r >= l){
            int middle = l + (r - l) / 2;
            int col = middle % n;
            int row = middle / n;
            if (target > matrix[row][col])
                l = middle + 1;
            else if (target < matrix[row][col])
                r = middle - 1;
            else
                return middle;
        }
        return -1;
    }
     */
}
