/*
234. ��������
���ж�һ�������Ƿ�Ϊ��������

ʾ�� 1:

����: 1->2
���: false
ʾ�� 2:

����: 1->2->2->1
���: true
���ף�
���ܷ��� O(n) ʱ�临�ӶȺ� O(1) �ռ临�ӶȽ�����⣿
 */
package LinkedList;

public class Q234���ĵ����� {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*
    // ����1 : ʹ��hashֵ  ǰ�����ͺ������hashֵ��ͬ  ˵��Ϊ����
    public boolean isPalindrome(ListNode head) {
        long hash1 = 0l; long hash2 = 0l;
        long h = 1l;
        long seed = 7;
        ListNode point = head;
        while(point != null){
            hash1 = hash1 * seed + point.val;
            hash2 = hash2 + h * point.val;
            h = h * seed;
            point = point.next;
        }
        return hash1 == hash2;
    }

     */

    // ����2 : �ݹ鷨 �
    // ʹ��һ��ȫ�ֱ����洢 ͷ���ڵ�preNode  ���ݹ鵽���һ��ʱ  ����β���ڵ� ��ͷ���ڵ���бȽ�
    // Ȼ��preNode = preNode.next��ͬʱ�ݹ���˵���һ�㣬 head = head.pre
    ListNode preNode = null;
    public boolean isPalindrome(ListNode head) {
        preNode = head;
        return recursiveCheck(head);
    }

    public boolean recursiveCheck(ListNode head){
        if (head != null){
            if (! recursiveCheck(head.next))
                return false;

            if (preNode.val != head.val)
                return false;
            preNode = preNode.next;
        }

        return true;
    }

    /*
    // ����3 : ����ָ�뷨  ʱ�临�Ӷ�ΪO(1)
    // �������̿��Է�Ϊ�����������
    // 1.�ҵ�ǰ�벿�������β�ڵ㡣
    // 2.��ת��벿������
    // 3.�ж��Ƿ���ġ�
    // 4.�ָ�����
    // 5.���ؽ����
    boolean ans = true;
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode lastHalf = reverse(slow);
        ListNode firstHalf = head;
        while (firstHalf != null){
            if ( firstHalf.val != lastHalf.val)
            {
                ans = false;
                break;
            }
            else{
                firstHalf = firstHalf.next;
                lastHalf = lastHalf.next;
            }
        }
        reverse(slow);
        return ans;
    }

    public ListNode reverse(ListNode head){
        if (head == null || head.next == null)
            return head;
        ListNode reversed = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return reversed;
    }
     */

}
