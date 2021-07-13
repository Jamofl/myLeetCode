package LinkedList;

import java.util.*;

public class Offer06从后到前打印链表 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // Solution1 借助栈
    public int[] reversePrint(ListNode head) {
        if (head == null)
            return new int[]{};
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        int[] ans = new int[stack.size()];
        for (int i = 0; i < ans.length; i++)
            ans[i] = stack.pop().val;
        return ans;
    }

    // Solution2 使用递归的思想  逆序返回
    public int[] reversePrint2(ListNode head) {
        if (head == null)
            return new int[] {};
        List<Integer> lst = new ArrayList<>();
        reverseRec(head, lst);
        int[] ans = new int[lst.size()];
        for (int i = 0; i < lst.size(); i ++)
            ans[i] = lst.get(i);
        return ans;
    }

    private void reverseRec(ListNode head, List<Integer> lst){
        if (head == null)
            return;
        reverseRec(head.next, lst);
        lst.add(head.val);
    }

}
