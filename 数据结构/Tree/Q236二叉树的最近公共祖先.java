/*
236. �������������������
����һ��������, �ҵ�����������ָ���ڵ������������ȡ�

�ٶȰٿ�������������ȵĶ���Ϊ���������и��� T ��������� p��q������������ȱ�ʾΪһ����� x������ x �� p��q �������� x ����Ⱦ����ܴ�һ���ڵ�Ҳ���������Լ������ȣ�����

���磬�������¶�����:  root = [3,5,1,6,2,0,8,null,null,7,4]





ʾ�� 1:

����: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
���: 3
����: �ڵ� 5 �ͽڵ� 1 ��������������ǽڵ� 3��
ʾ�� 2:

����: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
���: 5
����: �ڵ� 5 �ͽڵ� 4 ��������������ǽڵ� 5����Ϊ���ݶ�������������Ƚڵ����Ϊ�ڵ㱾��


˵��:

���нڵ��ֵ����Ψһ�ġ�
p��q Ϊ��ͬ�ڵ��Ҿ������ڸ����Ķ������С�
 */
package ���ݽṹ.Tree;
import java.util.*;
public class Q236������������������� {

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

         private int height(TreeNode root){
             if (root == null)
                 return 0;
             if (root.left == null && root.right == null)
                 return  1;
             return 1 + Math.max(height(root.left), height(root.right));
         }

        private boolean equals(Object o1, Object o2){
            if (o1 == null)
                return o2 == null;
            return o1.equals(o2);
        }
        @Override
        public boolean equals(Object obj) {
          if (obj == null || ! (obj instanceof TreeNode))
              return false;
          TreeNode that = (TreeNode) obj;
          return equals(this.val, that.val)
                  && equals(this.left, that.left)
                  && equals(this.right, that.right);
        }

         @Override
         public int hashCode() {
             int result = this.val;
             if (this.left != null)
                 result += this.left.hashCode();
             if (this.right != null)
                 result += this.right.hashCode();
             return result;
         }
     }


     /*
     // Solution 1: �ֱ��ҵ������ڵ�� path-to-root, Ȼ����������path�ĵ�һ�����㣬��Ϊ��͹������ȡ�
     // ���Ӷ�: O(N + logN 2��
    public TreeNode ROOT;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.ROOT = root;
        LinkedList<TreeNode> path1 = new LinkedList();
        LinkedList<TreeNode> path2 = new LinkedList();
        findNode(path1, root, p);
        findNode(path2, root, q);
        //System.out.println(path1);
        //System.out.println(path2);

        for(TreeNode n : path1){
            if (path2.contains(n))
                return n;
        }
        return ROOT;
    }

    private boolean findNode(LinkedList<TreeNode> path, TreeNode root, TreeNode target){
        if (root == null)
            return false;
        else if (target.equals(root)){
            path.add(root);
            return true;
        }
        else if (findNode(path, root.left, target) || findNode(path, root.right, target)) {
            path.add(root);
            return true; // return true�ܹؼ���
        }
        return false;
    }

    */
    // Solution 2: O(n)
    // �ȶ�����������dfs���ҵ�ÿ���ڵ�ĸ��ڵ㣬����һ��ӳ�䡣Ȼ������p��path to root�� ����q��path to root�� �ҹ������㡣

    private static HashMap<TreeNode, TreeNode> map = new HashMap();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        getParentMap(root);
        Set<Integer> path1 = new HashSet();
        while (p != null){
            path1.add(p.val);
            p = map.get(p);
        }

        while (q != null){
            if (path1.contains(q.val))
                return q;
            q = map.get(q);
        }
        return null;
    }

    private void getParentMap(TreeNode root){
        if (root.left != null){
            map.put(root.left, root);
            getParentMap(root.left);
        }

        if (root.right != null){
            map.put(root.right, root);
            getParentMap(root.right);
        }
    }

    // ����3 �ݹ鷨
    // ����leftPQ rightPQ��ʾ�����������������к���P��Q
    // ��ǰ�ڵ�Ϊlca�������ȼ��� =>
    // ((leftPQ && rightPQ) || ((root.val == p.val || root.val == q.val) && (leftPQ || rightPQ)))
    // �� ��������������������pq  ����   ��ǰ�ڵ�Ϊpq �� ������������������pq
    TreeNode lca;
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        this.lca = null;
        dfs(root, p, q);
        return this.lca;

    }

    // ״̬һ��Ҫ����ԣ�
    // ����leftPQ rightPQ��ʾ�����������������к���P��Q
    // dfs���صĽ������ ��ǰ�ڵ�root��root�������к���P��Q
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q){
        if (root == null)
            return false;

        boolean leftPQ = dfs(root.left, p, q); // ��ʾ�������к���pq
        boolean rightPQ = dfs(root.right, p, q);// ��ʾ�������к���pq
        if ((leftPQ && rightPQ) ||
                ((root.val == p.val || root.val == q.val) && (leftPQ || rightPQ)))
            lca = root;

        // �������������pq  ��  ����������pq   ��   ���ڵ����pq �򷵻�true
        return leftPQ || rightPQ || (root.val == q.val) || (root.val == p.val);
    }



     public static void main(String[] args){
         Q236������������������� q = new Q236�������������������();
         TreeNode t = new TreeNode(3, new TreeNode(1, new TreeNode(2), new TreeNode(5)), new TreeNode(4));
         TreeNode re = q.lowestCommonAncestor(t, new TreeNode(1, new TreeNode(2), new TreeNode(5)), new TreeNode(5));
         System.out.println(re.val);
    }
}
