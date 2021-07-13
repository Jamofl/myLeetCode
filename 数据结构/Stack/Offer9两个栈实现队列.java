package ���ݽṹ.Stack;
/*
��ָ Offer 09. ������ջʵ�ֶ���
������ջʵ��һ�����С����е��������£���ʵ�������������� appendTail �� deleteHead ���ֱ�����ڶ���β�������������ڶ���ͷ��ɾ�������Ĺ��ܡ�(��������û��Ԫ�أ�deleteHead �������� -1 )



ʾ�� 1��

���룺
["CQueue","appendTail","deleteHead","deleteHead"]
[[],[3],[],[]]
�����[null,null,3,-1]
ʾ�� 2��

���룺
["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
[[],[],[5],[2],[],[]]
�����[null,-1,null,null,5,2]
��ʾ��

1 <= values <= 10000
����� appendTail��deleteHead ���� 10000 �ε���
 */
import java.util.*;
public class Offer9����ջʵ�ֶ��� {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public Offer9����ջʵ�ֶ���() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack1.size() == 0 && stack2.size() == 0)
            return -1;
        if (stack2.size() != 0)
            return stack2.pop();
        else{
            while (stack1.size() != 0)
                stack2.push(stack1.pop());
            return stack2.pop();
        }
    }
}
