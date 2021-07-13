/*
239. �����������ֵ
����һ���������� nums����һ����СΪ k �Ļ������ڴ������������ƶ�����������Ҳࡣ��ֻ���Կ����ڻ��������ڵ� k �����֡���������ÿ��ֻ�����ƶ�һλ��

���ػ��������е����ֵ��
ʾ�� 1��

���룺nums = [1,3,-1,-3,5,3,6,7], k = 3
�����[3,3,5,5,6,7]
���ͣ�
�������ڵ�λ��                ���ֵ
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
ʾ�� 2��

���룺nums = [1], k = 1
�����[1]
ʾ�� 3��

���룺nums = [1,-1], k = 1
�����[1,-1]
ʾ�� 4��

���룺nums = [9,11], k = 2
�����[11]
ʾ�� 5��

���룺nums = [4,-2], k = 2
�����[4]

��ʾ��

1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length
 */
package ���ݽṹ.MonotonouosStack;

import java.util.LinkedList;

public class Q239�������ڵ����ֵ {
    // Solution 1: �����ⷨ��O(N * k)
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        int firstNum = 0;
//        int n = nums.length;
//        int max = Integer.MIN_VALUE;
//        int[] ans = new int[n - k + 1];
//
//        LinkedList<Integer> subList = new LinkedList<>();
//
//        for(int i = 0; i < k; i ++)
//            subList.add(nums[i]);
//        for(int i : subList){
//            if (i > max)
//                max = i;
//        }
//        ans[0] = max;
//        firstNum = subList.getFirst();
//
//        for (int i = 1 ; i <= n - k; i ++){
//            subList.removeFirst();
//            subList.addLast(nums[i + k - 1]);
//            if (firstNum != max){
//                if (subList.getLast() > max){
//                    max = subList.getLast();
//                }
//            }
//            else{
//                if (subList.getLast() > firstNum)
//                    max = subList.getLast();
//                else{
//                    max = Integer.MIN_VALUE;
//                    for(int j : subList){
//                        if (j > max)
//                            max = j;
//                    }
//                }
//            }
//            firstNum = subList.getFirst();
//            ans[i] = max;
//        }
//        return ans;
//    }

    // Solution 2: ��������.
    // ά��һ������ΪL ~ R�ĵ������С�ÿ��L���ڵ���������ջ����ߵ�����ʱ�����������Ԫ�ء�
    // ջ�е�Ԫ�ص����ݼ���ÿ������Ԫ�ؼ���ʱ����ջ�����ұߵ�Ԫ�رȽϣ������ұ�Ԫ��С���¼���Ԫ�أ��򵯳���ֱ�����ұ�Ԫ�ش����¼���Ԫ��Ϊֹ��
    //
    // ����: nums = [1,3,-1,-3,5,3,6,7], �� k = 3
    // ���: [3,3,5,5,6,7]
    //
    // ���͹����ж����ж��Ǿ����ֵ��������⣬��������롣
    // ��ʼ״̬��L=R=0,����:{}
    // i=0,nums[0]=1������Ϊ��,ֱ�Ӽ��롣���У�{1}
    // i=1,nums[1]=3����βֵΪ1��3>1��������βֵ������3�����У�{3}
    // i=2,nums[2]=-1����βֵΪ3��-1<3��ֱ�Ӽ��롣���У�{3,-1}����ʱ�����Ѿ��γɣ�L=0,R=2��result=[3]
    // i=3,nums[3]=-3����βֵΪ-1��-3<-1��ֱ�Ӽ��롣���У�{3,-1,-3}������3��Ӧ���±�Ϊ1��L=1,R=3����Ч��result=[3,3]
    // i=4,nums[4]=5����βֵΪ-3��5>-3�����ε�������롣���У�{5}����ʱL=2,R=4����Ч��result=[3,3,5]
    // i=5,nums[5]=3����βֵΪ5��3<5��ֱ�Ӽ��롣���У�{5,3}����ʱL=3,R=5����Ч��result=[3,3,5,5]
    // i=6,nums[6]=6����βֵΪ3��6>3�����ε�������롣���У�{6}����ʱL=4,R=6����Ч��result=[3,3,5,5,6]
    // i=7,nums[7]=7����βֵΪ6��7>6��������βֵ����롣���У�{7}����ʱL=5,R=7����Ч��result=[3,3,5,5,6,7]

    public int[] maxSlidingWindow(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        LinkedList<Integer> q = new LinkedList(); // queue��������Ԫ�ص��±�

        while (r < k){
            offer(q, nums, r);
            r ++;
        }
        ans[l] = nums[q.getFirst()];

        while(r <= n - 1){
            if (l == q.getFirst())
                q.removeFirst();
            offer(q, nums, r);
            r ++;
            l ++;
            ans[l] = nums[q.getFirst()];
        }
        return ans;
    }

    private void offer(LinkedList<Integer> lst, int[] nums, int i){
        while(lst.size() != 0 && nums[lst.getLast()] < nums[i]){
            lst.removeLast();
        }
        lst.add(i);
    }

    public static void main(String[] args){
        Q239�������ڵ����ֵ q = new Q239�������ڵ����ֵ();
        int[] t = new int[]{1,3,-1,-3,5,3,6,7};
        int[] re = q.maxSlidingWindow(t, 3);
        System.out.println(re);
    }
}
