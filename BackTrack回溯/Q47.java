/*
47. 全排列 II
给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。



示例 1：

输入：nums = [1,1,2]
输出：
[[1,1,2],
 [1,2,1],
 [2,1,1]]
示例 2：

输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]


提示：

1 <= nums.length <= 8
-10 <= nums[i] <= 10
 */
package BackTrack回溯;
import java.util.*;

public class Q47 {

    /*
    Solution 1:使用交换位置的方法，依次将第一个元素与第一个、第二个、第三个...元素交换位置，
    然后进入下一层dfs，当index等于数组长度时，将其加入答案中，然后依次回退到上一层，还原交换的位置。
    去重的思想在于，通过一个Set，将遍历过的数字加入到集合中（也可以直接对结果加入set去重后再转为数组，费时），再遇到相同的数字，直接跳过本次循环。
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new LinkedList();
        LinkedList<Integer> lst = new LinkedList();
        for(int num : nums)
            lst.addLast(num);
        dfs(ans, lst, 0, nums.length);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, LinkedList<Integer> lst, int index, int n){
        if (index == n){
            ans.add(new LinkedList(lst));
            return;
        }
        Set<Integer> set = new HashSet();
        for(int j = index; j < n; j ++){
            int temp = lst.get(j);
            if (set.contains(temp))
                continue;
            set.add(temp);
            Collections.swap(lst, index, j);
            dfs(ans, lst, index + 1, n);
            Collections.swap(lst, index, j);
        }
    }

    public static void main(String[] args){
//        Q47 q = new Q47();
//        List l = q.permuteUnique(new int[]{1,3,3});
        String s = "aaabb";
        String[] temp = s.split("b");
        System.out.println();
    }
}
