/*
59. �������� II
����һ�������� n ������һ������ 1 �� n2 ����Ԫ�أ���Ԫ�ذ�˳ʱ��˳���������е� n x n �����ξ��� matrix ��



ʾ�� 1��


���룺n = 3
�����[[1,2,3],[8,9,4],[7,6,5]]
ʾ�� 2��

���룺n = 1
�����[[1]]


��ʾ��

1 <= n <= 20
ͨ������60,236�ύ����76,739
 */
package Array;

public class Q59��������2 {

    // ˳ʱ��ģ�����
    // ʼ����ѭ������ҿ������ԭ�� ������� n = 4 �ľ��󣬵�һ�����ʱֻ��3��
    // ����nΪ�������������Ҫ���⴦��
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
        int i = 0, j = 0;
        int m = n - 1;
        int count = 0;
        while (num <= n * n){
            if (m == 0){ // n Ϊ����ʱ�����⴦��
                matrix[i][j] = num;
                num ++;
                continue;
            }

            while (count < m){ // ���һ���
                matrix[i][j] = num;
                num ++;
                count ++;
                j ++;
            }
            count = 0;


            while (count < m){ // ���»���
                matrix[i][j] = num;
                num ++;
                count ++;
                i ++;
            }
            count = 0;


            while (count < m){ // ������
                matrix[i][j] = num;
                num ++;
                count ++;
                j --;
            }
            count = 0;


            while (count < m){ // ���ϻ���
                matrix[i][j] = num;
                num ++;
                count ++;
                if (count == m) // ������Ȧ
                    j ++;
                else
                    i --;
            }
            count = 0;
            m = m - 2;
        }
        return matrix;
    }

    public static void main(String[] args){
        Q59��������2 q = new Q59��������2();
        int[][] m = q.generateMatrix(7);
        System.out.println();

    }
}
