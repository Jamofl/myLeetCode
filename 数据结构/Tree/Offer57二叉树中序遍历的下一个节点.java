package ���ݽṹ.Tree;
/*
����һ�������������е�һ����㣬���ҳ��������˳�����һ����㲢�ҷ��ء�
ע�⣬���еĽ�㲻�����������ӽ�㣬ͬʱ����ָ�򸸽���ָ�롣
https://www.nowcoder.com/practice/9023a0c988684a53960365b889ceaf5e?tpId=13&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tab=answerKey
 */
public class Offer57�����������������һ���ڵ� {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
    private TreeLinkNode getSuccessor(TreeLinkNode node){
        while (node.left != null)
            node = node.left;
        return node;
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode.right != null){
            return getSuccessor(pNode.right);
        }
        else{
            if (pNode.next == null)
                return null;
            else if (pNode.val < pNode.next.val)
                return pNode.next;
            else{
                TreeLinkNode temp = pNode;
                while (temp.next != null && temp.val > temp.next.val){
                    temp = temp.next;
                }
                return temp.next;
            }
        }

    }
}
