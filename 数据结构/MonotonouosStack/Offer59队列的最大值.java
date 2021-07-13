package ���ݽṹ.MonotonouosStack;
/*
��ָ Offer 59 - II. ���е����ֵ
�붨��һ�����в�ʵ�ֺ��� max_value �õ�����������ֵ��Ҫ����max_value��push_back �� pop_front �ľ�̯ʱ�临�Ӷȶ���O(1)��

������Ϊ�գ�pop_front �� max_value ��Ҫ���� -1

ʾ�� 1��

����:
["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
[[],[1],[2],[],[],[]]
���: [null,null,null,2,1,2]
ʾ�� 2��

����:
["MaxQueue","pop_front","max_value"]
[[],[],[]]
���: [null,-1,-1]


���ƣ�

1 <= push_back,pop_front,max_value���ܲ����� <= 10000
1 <= value <= 10^5
 */
import java.util.*;

public class Offer59���е����ֵ {
    Deque<Integer> monoQueue;
    Queue<Integer> q;
    public Offer59���е����ֵ() {
        monoQueue = new LinkedList<>();
        q = new LinkedList<>();
    }

    public int max_value() {
        if (q.size() == 0)
            return -1;
        return monoQueue.peekFirst();
    }

    public void push_back(int value) {
        q.offer(value);
        offer(monoQueue, value);
    }

    public int pop_front() {
        if (q.size() == 0)
            return -1;
        int toReturn = q.poll();
        if (toReturn == monoQueue.peekFirst())
            monoQueue.pollFirst();
        return toReturn;
    }

    private void offer(Deque<Integer> monoQueue, int n){
        while (monoQueue.size() != 0 && monoQueue.peekLast() < n)
            monoQueue.pollLast();
        monoQueue.offerLast(n);
    }

    public static void main(String[] args){
        Offer59���е����ֵ q = new Offer59���е����ֵ();
        q.push_back(1);
        q.push_back(2);
        System.out.println(q.max_value());
        q.pop_front();
        System.out.println(q.max_value());
    }
}
