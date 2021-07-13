/*
128. ���������
����һ��δ������������� nums ���ҳ���������������У���Ҫ������Ԫ����ԭ�������������ĳ��ȡ�

���ף��������Ʋ�ʵ��ʱ�临�Ӷ�Ϊ O(n) �Ľ��������


ʾ�� 1��

���룺nums = [100,4,200,1,3,2]
�����4
���ͣ���������������� [1, 2, 3, 4]�����ĳ���Ϊ 4��
ʾ�� 2��

���룺nums = [0,3,7,2,5,8,4,6,0,1]
�����9
 */
package ���ݽṹ.DisjointSet;
import java.util.*;

public class Q128����������� {
    private class UnionFind{

        // ����1  ���鼯�ķ���
        // ����һ��parent ��ʾ�ӵ�ǰ�ڵ㵽���ڵ��ӳ��
        // ע�����������д�����С�����Ԫ��  �ʲ�������-n�ķ�ʽ����ʾ��ǰ���ڵ��ж��ٸ�����
        public Map<Integer, Integer> parent;
        public UnionFind(int[] nums){
            this.parent = new HashMap();
            for (int num : nums)
                parent.put(num, num);
        }

        public void union(int m, int n){
            int rootM = find(m);
            int rootN = find(n);
            if (rootM == rootN)
                return ;
            parent.put(rootN, rootM);
        }

        // return root of n; do the path compression at the same time
        public int find(int n){
            int root = n;
            while (parent.get(root) != root)
                root = parent.get(root);

            int cur = n;
            while (parent.get(cur) != root){
                int preParent = parent.get(cur);
                parent.put(cur, root);
                cur = preParent;
            }
            return root;
        }

        public int getLongestCons(){
            int ans = 0;
            for (Integer i : this.parent.keySet()){
                ans = Math.max(ans, Math.abs(find(i) - i) + 1);
            }
            return ans;
        }
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;

        UnionFind uf = new UnionFind(nums);

        for (int num : nums){
            if (uf.parent.containsKey(num + 1)){
                uf.union(num, num + 1);
            }
        }


        return uf.getLongestCons();
    }
}
