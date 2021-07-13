package ���ݽṹ.Tree;
import java.util.*;
/*
662. �����������
����һ������������дһ����������ȡ�����������ȡ����Ŀ�������в��е�����ȡ����������������������full binary tree���ṹ��ͬ����һЩ�ڵ�Ϊ�ա�

ÿһ��Ŀ�ȱ�����Ϊ�����˵㣨�ò���������ҵķǿսڵ㣬���˵���null�ڵ�Ҳ���볤�ȣ�֮��ĳ��ȡ�

ʾ�� 1:

����:

           1
         /   \
        3     2
       / \     \
      5   3     9

���: 4
����: ���ֵ���������ĵ� 3 �㣬���Ϊ 4 (5,3,null,9)��
ʾ�� 2:

����:

          1
         /
        3
       / \
      5   3

���: 2
����: ���ֵ���������ĵ� 3 �㣬���Ϊ 2 (5,3)��
ʾ�� 3:

����:

          1
         / \
        3   2
       /
      5

���: 2
����: ���ֵ���������ĵ� 2 �㣬���Ϊ 2 (3,2)��
ʾ�� 4:

����:

          1
         / \
        3   2
       /     \
      5       9
     /         \
    6           7
���: 8
����: ���ֵ���������ĵ� 4 �㣬���Ϊ 8 (6,null,null,null,null,null,null,7)��
ע��: ����32λ�з��������ı�ʾ��Χ�ڡ�
 */
public class Q662����������� {
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


    // �½�һ��node�࣬Ŀ�ľ��Ǳ���node���ڵ�position�±�
    // ��ÿһ�㣬����Ⱦ��Ǹò����ұߵ�Ԫ�ص�id - �����Ԫ�ص�id
    // bfs ʵʱ���½�ֹ��ĿǰΪֹ�����ɿ�ȼ���
    public static class AnnotatedNode {
        TreeNode node;
        int pos;

        AnnotatedNode(TreeNode node, int pos) {
            this.node = node;
            this.pos = pos;
        }
    }


    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        return getWidth(root);
    }



    private int getWidth(TreeNode root){
        int width = 1;
        Deque<AnnotatedNode> q = new LinkedList<>();
        q.offer(new AnnotatedNode(root, 1));

        while (q.size() != 0) {
            int n = q.size();

            width = Math.max(width, q.getLast().pos - q.getFirst().pos  + 1); // ��Ⱦ��Ƕ�βԪ�ص��±� - ����Ԫ���±� + 1
            while (n > 0){
                AnnotatedNode pop = q.poll();
                if (pop.node.left != null)
                    q.offer(new AnnotatedNode(pop.node.left, pop.pos * 2));
                if (pop.node.right !=null)
                    q.offer(new AnnotatedNode(pop.node.right, pop.pos * 2 + 1));
                n --;
            }
        }
        return width;
    }



    public static void main(String[] args){
        Q662����������� q = new Q662�����������();
        TreeNode t = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        int r = q.getWidth(t);
        System.out.println(r);
    }
}
