package 数据结构.Tree;

/*
https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
剑指 Offer 26. 树的子结构
输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)

B是A的子结构， 即 A中有出现和B相同的结构和节点值。

例如:
给定的树 A:

     3
    / \
   4   5
  / \
 1   2
给定的树 B：

   4
  /
 1
返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 */
public class Offer26树的子结构 {
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

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null)
            return false;
        else if (contains(A, B))
            return true;
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean contains(TreeNode A, TreeNode B) {
        if (B == null) // 树B为空 说明子树已经遍历完毕 返回true
            return true;
        if (A == null)      // 树A为空 空树不可能包含任何子树 返回false
            return false;
        return A.val == B.val && contains(A.left, B.left) && contains(A.right, B.right);
    }

    // private boolean isSubStructureRec(TreeNode A, TreeNode B) {
    //     if (A == null)
    //         return false;
    //     else if (contains(A, B))
    //         return true;
    //     else {
    //         return isSubStructureRec(A.left, B) || isSubStructureRec(A.right, B);
    //     }
    // }



    public static void main(String[] args) {
        Offer26树的子结构 Q = new Offer26树的子结构();
//        TreeNode t = new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(2)), new TreeNode(5));
        TreeNode t = new TreeNode(3, new TreeNode(1), new TreeNode(4));
        TreeNode t2 = new TreeNode(4);
        System.out.println(Q.isSubStructure(t, t2));

    }
}
