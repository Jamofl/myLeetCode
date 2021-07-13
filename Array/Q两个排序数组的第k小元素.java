package Array;

import java.util.LinkedList;

public class Q������������ĵ�kСԪ�� {


    // ����1 ֱ���� ���Ӷ�ΪO��k��
    public int findKthSmallest(int[] nums1, int[] nums2, int k){
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length){
            if (k == 0)
                return Math.min(nums1[i], nums2[j]);
            if (nums1[i] < nums2[j])
                i ++;
            else
                j ++;
            k --;
        }

        while (i < nums1.length){
            if (k == 0)
                return nums1[i];
            i ++;
            k --;
        }

        while (j < nums2.length){
            if (k == 0)
                return nums2[j];
            j ++;
            k --;
        }
        return  -1;
    }

    // ����2 ���ֲ���  ÿ�β������������� k / 2 ����λ�õ�Ԫ��
    // ��A[k/2] < B[k/2], ��A������ǰk/2��Ԫ�ز���Ҫ���ǣ�
    // ��A[k/2] > B[k/2], ��B������ǰk/2��Ԫ�ز���Ҫ���ǣ�
    // ��A[k/2] = B[k/2], ˵���ҵ��˵�kСԪ�أ�����A[k/2]

    public int findKthSmallest2(int[] nums1, int start1, int[] nums2, int start2, int k){
        if (nums1.length > nums2.length)
            return findKthSmallest2(nums2, start2, nums1, start1, k);

        else if (k == 1)
            return Math.min(nums1[start1], nums2[start2]);
        else if (start1 >= nums1.length)
            return nums2[start2 + k - 1];

        int x = (start1 + k / 2 >= nums1.length) ? nums1.length : start1 + k / 2;
        int y = (start2 + k / 2 >= nums2.length) ? nums2.length : start2 + k / 2;

        if (nums1[x - 1] < nums2[y - 1])
            return findKthSmallest2(nums1, start1 + x, nums2, start2, k - x);
        else if (nums1[x - 1] > nums2[y - 1])
            return findKthSmallest2(nums1, start1, nums2, start2 + y, k - y);
        else
            return nums1[x - 1];
    }



    public static void main(String[] args){
        int[] nums1 = new int[] {1,4};
        int[] nums2 = new int[] {2,5,7,8,9,10};
        Q������������ĵ�kСԪ�� q = new Q������������ĵ�kСԪ��();
        int k = 5;
        int r = q.findKthSmallest2(nums1,0, nums2, 0, k);
        int r2 = q.findKthSmallest(nums1, nums2, k - 1);
        System.out.println(r);
        System.out.println(r2);

        LinkedList<int[]> lst = new LinkedList<>();

    }

}
