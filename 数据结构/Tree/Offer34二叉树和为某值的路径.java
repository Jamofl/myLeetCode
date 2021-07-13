package 数据结构.Tree;
import java.util.*;

/*
https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
剑指 Offer 34. 二叉树中和为某一值的路径
输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 */
public class Offer34二叉树和为某值的路径 {

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
