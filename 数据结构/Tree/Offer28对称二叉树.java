package 数据结构.Tree;

public class Offer28对称二叉树 {
    public static class TreeNode {
        int val = Integer.MAX_VALUE;
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

    /*
    // wrong solution 不可以采用层序遍历对比的方式 因为可能会存在null的节点 不好做特殊处理
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return levelOrderCheck(root);
    }

    private boolean levelOrderCheck(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() > 0){
            LinkedList<Integer> level = new LinkedList<>();
            int m = queue.size();
            while (m > 0){
                TreeNode pop = queue.poll();
                level.add(pop.val);
                m --;

                if (pop.left == null && pop.right == null)
                    continue;
                if (pop.left != null)
                    queue.add(pop.left);
                else
                    queue.add(new TreeNode());

                if (pop.right != null)
                    queue.add(pop.right);
                else
                    queue.add(new TreeNode());
            }
            System.out.println(level.toString());
            while (level.size() > 0){
                if (level.size() == 1)
                    level.removeFirst();
                else{
                    int first = level.removeFirst();
                    int last = level.removeLast();
                    if (first != last)
                        return false;
                }
            }
        }
        return true;
    }
     */

    /*
    递归解法
    对称树的条件为：
    left.val == right.val
    left.right == right.left
    left.left == right.right
     */
    public boolean isSymmetric(TreeNode root) {
        return recursion(root, root);
    }

    /*
    巧妙传入两棵树 对称的条件为：p.val == q.val && p.left == q.right && p.right == q.left
     */
    private boolean recursion(TreeNode p, TreeNode q){
        if (p == null && q == null) // 如果P Q都为空树 则对称
            return true;
        else if (p != null && q != null)  // 对称的条件为：p.val == q.val && p.left == q.right && p.right == q.left
            return p.val == q.val && recursion(q.left, p.right) && recursion(q.right, p.left);
        else
            return false;
    }

    public static void main(String[] args) {
        Offer28对称二叉树 o = new Offer28对称二叉树();
        TreeNode t = new TreeNode(1, new TreeNode(0), null);
        System.out.println(o.isSymmetric(t));

    }

}
