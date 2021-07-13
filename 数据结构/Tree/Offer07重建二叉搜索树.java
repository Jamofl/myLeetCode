package 数据结构.Tree;

import java.util.HashMap;
import java.util.Map;

public class Offer07重建二叉搜索树 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

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

    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i ++)
            map.put(inorder[i], i);
        int count = preorder.length;
        return buildTreeHelper(preorder, inorder, 0, count - 1, 0, count - 1);
    }

    public TreeNode buildTreeHelper(int[] preorder, int[] inorder, int start1, int end1, int start2, int end2) {
        if (end1 < start1 || end2 <start2)
            return null;

        int root = preorder[start1];
        int indexOfRootInOrder = map.get(root);
        int leftCount = indexOfRootInOrder - start2;
        int rightCount = end2 - indexOfRootInOrder;
        TreeNode treeNode = new TreeNode(root);
        if (leftCount != 0)
            treeNode.left = buildTreeHelper(preorder, inorder, start1 + 1, start1 + leftCount, start2, start2 + leftCount - 1);
        if (rightCount != 0)
            treeNode.right = buildTreeHelper(preorder, inorder, end1 - rightCount + 1, end1, end2 - rightCount + 1, end2);
        return treeNode;
    }

    public static void main(String[] args) {
        Offer07重建二叉搜索树 q = new Offer07重建二叉搜索树();
        TreeNode t = q.buildTree(new int[] {3,9,20,15,7}, new int[] {9,3,15,20,7});
        System.out.println(1);
    }

}
