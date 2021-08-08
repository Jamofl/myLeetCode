/**
 * 102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 *
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
import com.sun.source.tree.Tree;

import java.util.*;
public class Q102 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
        TreeNode(int x, TreeNode left, TreeNode right){
            val = x;
            this.left = left;
            this.right = right;
        }
    }

    LinkedList<TreeNode> q;
    List<List<Integer>> ans;
    public List<List<Integer>> levelOrder(TreeNode root) {
        q = new LinkedList();
        ans = new LinkedList();

        if(root == null)
            return ans;
        bfs(root);
        return ans;
    }

    private void bfs(TreeNode root){
        q.add(root);
        while (! q.isEmpty()){
            TreeNode temp;
            List<Integer> lstInteger = new LinkedList();
            List<TreeNode> lstTree = new LinkedList();
            while(q.size() != 0){
                temp = q.remove(0);
                lstTree.add(temp);
                lstInteger.add(temp.val);
            }
            ans.add(lstInteger);
            for(TreeNode tree : lstTree){
                if(tree.left != null)
                    q.add(tree.left);
                if(tree.right != null)
                    q.add(tree.right);
            }
        }
    }

    public static void main(String[] args){
        TreeNode t = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        Q102 q = new Q102();
        List re = q.levelOrder(t);
        System.out.println();
    }
}
