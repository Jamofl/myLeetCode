package ���ݽṹ.Tree;
/*
https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
��ָ Offer 54. �����������ĵ�k��ڵ�
����һ�ö��������������ҳ����е�k��Ľڵ㡣

ʾ�� 1:

����: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
���: 4
ʾ�� 2:

����: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
���: 4

���ƣ�

1 �� k �� ����������Ԫ�ظ���
 */
import java.util.*;

public class Offer54�������ĵ�k��ڵ� {
    public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) {
              this.val = val;
              this.left = null;
              this.right = null;
          }
          TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
              this.left = left;
              this.right = right;
          }
    }

    // �ⷨ1 : level order����������Ȼ������Ȼ��ȡ �� n - k ��Ԫ��  �ȽϺ�ʱ
    public int kthLargest(TreeNode root, int k) {
        List<Integer> lst = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (queue.size() != 0){
            int m = queue.size();
            while (m > 0){
                TreeNode pop = queue.poll();
                lst.add(pop.val);
                if (pop.left != null)
                    queue.offer(pop.left);
                if (pop.right != null)
                    queue.offer(pop.right);
                m --;
            }
        }
        // System.out.println(lst);
        Collections.sort(lst);
        // System.out.println(lst);
        return lst.get(lst.size() - k);
    }

    // �ⷨ2 �� ��������������ķ�ʽ������-��-��)�ķ�ʽ��������������������k���ڵ�ʱ��return
    public int k;
    public int kthLargest2(TreeNode root, int k) {
        List<Integer> lst = new LinkedList<>();
        this.k = k;
        inOrder(root, lst);
        return lst.get(lst.size() - 1);
    }

    private void inOrder(TreeNode root, List<Integer> lst){
        if (root == null)
            return;

        inOrder(root.right, lst);
        if (k == 0)  // �����������������k�Ѿ�Ϊ0 ֱ�ӷ���
            return;
        lst.add(root.val);
        k --;
        if (k == 0)  // ������ڵ㷢��k�Ѿ�Ϊ0 ֱ�ӷ���
            return;
        inOrder(root.left, lst); // ��������������Թ�Ϊ�������͸��ڵ�����
    }
}
