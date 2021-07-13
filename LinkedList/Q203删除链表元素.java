/*
203. �Ƴ�����Ԫ��
ɾ�������е��ڸ���ֵ val �����нڵ㡣

ʾ��:

����: 1->2->6->3->4->5->6, val = 6
���: 1->2->3->4->5
 */
package LinkedList;

public class Q203ɾ������Ԫ�� {
    private class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    // ʹ������ͷ��㣬ɾ��������
    // https://mp.weixin.qq.com/s/slM1CH5Ew9XzK93YOQYSjA
    public ListNode removeElements(ListNode head, int target) {
        if (head == null)
            return head;
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode point = dummyNode;
        while (point.next != null){
            if (point.next.val == target){
                point.next = point.next.next;
            }
            else
                point = point.next;
        }
        return dummyNode.next;
    }
}
