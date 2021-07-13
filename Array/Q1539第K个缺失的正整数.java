/*
1539. �� k ��ȱʧ��������
����һ�� �ϸ��������� ������������ arr ��һ������ k ��
�����ҵ����������� k ��ȱʧ����������

ʾ�� 1��

���룺arr = [2,3,4,7,11], k = 5
�����9
���ͣ�ȱʧ������������ [1,5,6,8,9,10,12,13,...] ���� 5 ��ȱʧ��������Ϊ 9 ��
ʾ�� 2��

���룺arr = [1,2,3,4], k = 2
�����6
���ͣ�ȱʧ������������ [5,6,7,...] ���� 2 ��ȱʧ��������Ϊ 6 ��

��ʾ��

1 <= arr.length <= 1000
1 <= arr[i] <= 1000
1 <= k <= 1000
�������� 1 <= i < j <= arr.length �� i �� j ���� arr[i] < arr[j]
 */
package Array;
import java.util.*;

public class Q1539��K��ȱʧ�������� {

    // ����1 ����ģ�ⷨ  O(N)
    // ģ��һ����1��ʼ��������������ʹ��count����ͳ��ȱʧ��Ԫ�ظ�������count == k,���ص�ǰ����
    public int findKthPositive(int[] arr, int k) {
        int index = 0;
        int count = 0;
        int i = 1;
        while (true){
            if (index >= arr.length)
                count ++;
            else{
                if (i != arr[index])
                    count ++;
                else
                    index ++;
            }

            if (count == k)
                return i;
            i ++;
        }
    }

    // ����2 ���ֲ��ҷ�  O(LOG N)
    // arr = 2 3 4 7 11
    // p   = 1 1 1 3 6  (p��ʾ����i��Ԫ��Ϊֹȱʧ��Ԫ�ص�����, p[i] = arr[i] - i - 1)
    // ���ǿ��Է���p�ǹ���i���ϸ񵥵�������
    public int findKthPositiv2(int[] arr, int k) {
        if (arr[0] > k)
            return k;

        int l = 0;
        int r = arr.length - 1;
        while (l <= r){
            int middle = l + (r - l) / 2;
            if (arr[middle] - middle - 1 >= k)
                r = middle - 1;
            else
                l = middle + 1;
        }
        return arr[r] + k - (arr[r] - r - 1);
    }

}
