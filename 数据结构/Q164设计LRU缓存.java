/*
146. LRU �������
�����������յ����ݽṹ����ƺ�ʵ��һ��  LRU (�������ʹ��) ������� ��
ʵ�� LRUCache �ࣺ

LRUCache(int capacity) ����������Ϊ���� capacity ��ʼ�� LRU ����
int get(int key) ����ؼ��� key �����ڻ����У��򷵻عؼ��ֵ�ֵ�����򷵻� -1 ��
void put(int key, int value) ����ؼ����Ѿ����ڣ�����������ֵ������ؼ��ֲ����ڣ��������顸�ؼ���-ֵ���������������ﵽ����ʱ����Ӧ����д��������֮ǰɾ�����δʹ�õ�����ֵ���Ӷ�Ϊ�µ�����ֵ�����ռ䡣


���ף����Ƿ������ O(1) ʱ�临�Ӷ�����������ֲ�����


ʾ����

����
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
���
[null, null, null, 1, null, -1, null, -1, 3, 4]

����
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // ������ {1=1}
lRUCache.put(2, 2); // ������ {1=1, 2=2}
lRUCache.get(1);    // ���� 1
lRUCache.put(3, 3); // �ò�����ʹ�ùؼ��� 2 ���ϣ������� {1=1, 3=3}
lRUCache.get(2);    // ���� -1 (δ�ҵ�)
lRUCache.put(4, 4); // �ò�����ʹ�ùؼ��� 1 ���ϣ������� {4=4, 3=3}
lRUCache.get(1);    // ���� -1 (δ�ҵ�)
lRUCache.get(3);    // ���� 3
lRUCache.get(4);    // ���� 4


��ʾ��

1 <= capacity <= 3000
0 <= key <= 3000
0 <= value <= 104
������ 3 * 104 �� get �� put
 */
package ���ݽṹ;
import java.util.*;
public class Q164���LRU���� {
    private class Node{
        public int key;
        public int val;
        public Node pre;
        public Node next;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
            this.pre = null;
            this.next = null;
        }
        public Node(int key, int val, Node pre, Node next){
            this.key = key;
            this.val = val;
            this.pre = pre;
            this.next = next;
        }
    }

    public Map<Integer, Node> map;
    public int capacity;
    public int size;
    public Node first;
    public Node last;

    public Q164���LRU����(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.first = new Node(-1, -1);
        this.last = new Node(-2, -2);
        this.first.next = this.last;
        this.last.pre = this.first;
    }

    public int get(int key) {
        if (! map.containsKey(key))
            return -1;
        Node target = map.get(key);
        moveToLast(target);
        return target.val;
    }

    public void put(int key, int value) {
        if (this.size >= this.capacity){
            map.remove(this.first.next.key);
            this.first.next.next.pre = this.first;
            this.first.next = this.first.next.next;
            this.size --;
        }

        if (map.containsKey(key)){
            Node target = map.get(key);
            target.val = value;
            moveToLast(target);
            return;
        }
        else {
            Node cur = new Node(key, value, this.last.pre, this.last);
            this.last.pre.next = cur;
            this.last.pre = cur;

            this.map.put(key, cur);
        }
        this.size ++;
    }

    private void moveToLast(Node target){
        target.pre.next = target.next;
        target.next.pre = target.pre;

        target.next = this.last;
        target.pre = this.last.pre;
        this.last.pre.next = target;
        this.last.pre = target;
    }

    public static void main(String[] args){
//        Q164���LRU lRUCache = new Q164���LRU(2);
//        int r = 0;
//        lRUCache.put(1, 1); // ������ {1=1}
//        lRUCache.put(2, 2); // ������ {1=1, 2=2}
//        r = lRUCache.get(1);    // ���� 1
//        lRUCache.put(3, 3); // �ò�����ʹ�ùؼ��� 2 ���ϣ������� {1=1, 3=3}
//        r = lRUCache.get(2);    // ���� -1 (δ�ҵ�)
//        lRUCache.put(4, 4); // �ò�����ʹ�ùؼ��� 1 ���ϣ������� {4=4, 3=3}
//        r = lRUCache.get(1);    // ���� -1 (δ�ҵ�)
//        r = lRUCache.get(3);    // ���� 3
//        r = lRUCache.get(4);    // ���� 4


    }
}
