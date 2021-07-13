package LinkedList;

import java.util.List;

/*
19. ɾ������ĵ����� N �����
����һ������ɾ������ĵ����� n ����㣬���ҷ��������ͷ��㡣

���ף����ܳ���ʹ��һ��ɨ��ʵ����
ʾ�� 1��


���룺head = [1,2,3,4,5], n = 2
�����[1,2,3,5]
ʾ�� 2��

���룺head = [1], n = 1
�����[]
ʾ�� 3��

���룺head = [1,2], n = 1
�����[1]


��ʾ��

�����н�����ĿΪ sz
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
 */
public class Q19ɾ�������е�����k���ڵ� {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            this.val = x;
            this.next = null;
        }

        ListNode(int x, ListNode next){
            this.val = x;
            this.next = next;
        }
    }

    // ˫ָ��һ��ɨ��
    // �����ڱ��ڵ�ָ��ͷ��㣬��ʼʱl r˫ָ���ָ���ڱ��ڵ㣬��l�����ƶ� n + 1�����룬����ʱ l  r ��� k + 1
    // ��r�ڵ�ָ��nullʱ�� l�ڵ�ָ������k���ڵ��ǰһ���ڵ�
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentinel = new ListNode(-1, head);
        ListNode l = sentinel;
        ListNode r = sentinel;

        int count = 0;
        while (count < n + 1){
            r = r.next;
            count ++;
        }

        while (r != null){
            l = l.next;
            r = r.next;
        }
        l.next = l.next.next;
        return sentinel.next;
    }
}
