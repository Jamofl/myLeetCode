package LinkedList链表;

/*
https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
剑指 Offer 18. 删除链表的节点
给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。

返回删除后的链表的头节点。

注意：此题对比原题有改动

示例 1:

输入: head = [4,5,1,9], val = 5
输出: [4,1,9]
解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
示例 2:

输入: head = [4,5,1,9], val = 1
输出: [4,5,9]
解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 */
public class Offer18删除链表节点 {

    private class ListNode{
        int val;
        ListNode next;
        public ListNode(){
            this.next = null;
        }
        public ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    // 兼容了可能存在重复元素的版本，删除后不要立即后移
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null)
            return null;
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode cur = dummyNode;
        while (cur.next != null){
            if (cur.next.val == val){        // 兼容了可能存在重复元素的版本，删除后不要立即后移
                cur.next = cur.next.next;
            }
            else                             // 当且仅当cur.next.val != val时，才后移，不会漏删元素
                cur = cur.next;
        }
        return dummyNode.next;
    }

    // 仅考虑当前题目描述的解，即：该链表中不会包含重复的元素，要删除的元素仅有一个，删完即可无脑后移。
    public ListNode deleteNode0(ListNode head, int val) {
        if (head == null)
            return null;
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode cur = dummyNode;
        while (cur != null){
            if (cur.next != null && cur.next.val == val){
                cur.next = cur.next.next;
            }
            cur = cur.next; // 删完即可后移，不存在漏删的情况，因为要删除的元素只有一个
        }
        return dummyNode.next;
    }
}
