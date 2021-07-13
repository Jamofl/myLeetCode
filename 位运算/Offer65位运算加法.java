package λ����;
/*
https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/
��ָ Offer 65. ���üӼ��˳����ӷ�
дһ������������������֮�ͣ�Ҫ���ں������ڲ���ʹ�� ��+������-������*������/�� ����������š�



ʾ��:

����: a = 1, b = 1
���: 2


��ʾ��

a, b �������Ǹ����� 0
���������� 32 λ����
 */
public class Offer65λ����ӷ� {


    /*
        �ⷨ��
        https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/solution/mian-shi-ti-65-bu-yong-jia-jian-cheng-chu-zuo-ji-7/
        s = a + b -> n + c
        ����nΪ�ǽ�λ�� cΪ��λ
        n = a ^ b           ���
        c = (a & b) << 1    ȡandȻ������һλ
     */
    public static void main(String[] args){
        int r = add(3,4);
        System.out.println(r);
    }

    // �ݹ鷨
    public int addRecursion(int a, int b) {
        if (a == 0 || b == 0)
            return a ^ b;    // 0 ^ n = n
        else
            return add(a ^ b, (a & b) << 1);
    }

    // ������
    public static  int add(int a, int b) {
        while (a != 0 & b != 0){
            int n = a ^ b;
            int c = (a & b) << 1;
            a = n;
            b = c;
        }
        return a ^ b;
    }
}
