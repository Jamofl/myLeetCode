package ���ݽṹ.Tree;
import java.util.*;

/*
https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
��ָ Offer 34. �������к�Ϊĳһֵ��·��
����һ�ö�������һ����������ӡ���������нڵ�ֵ�ĺ�Ϊ��������������·���������ĸ��ڵ㿪ʼ����һֱ��Ҷ�ڵ��������Ľڵ��γ�һ��·����
 */
public class Offer34��������Ϊĳֵ��·�� {

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

    public List<List<Integer>> ans;
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null)
            return new LinkedList<>();

        this.ans = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        path.add(root.val);
        dfs(path, root.val, target, root);
        return ans;
    }

    private void dfs(LinkedList<Integer> path, int sum, int target,TreeNode root){
        if (root == null)
            return;

        if (root.left == null && root.right == null && sum == target){
            ans.add(new LinkedList(path));
            return;
        }

        if (root.left != null){
            path.addLast(root.left.val);
            dfs(path, sum + root.left.val, target, root.left);
            path.removeLast();
        }
        if (root.right != null){
            path.addLast(root.right.val);
            dfs(path, sum + root.right.val, target, root.right);
            path.removeLast();
        }
    }
}
