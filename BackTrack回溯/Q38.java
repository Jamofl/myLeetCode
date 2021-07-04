/**
 * 剑指 Offer 38. 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。

 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * 示例:
 *
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 * 限制：
 *
 * 1 <= s 的长度 <= 8
 */
package BackTrack回溯;
import edu.princeton.cs.algs4.In;

import java.util.*;

public class Q38 {

    List<String> ans = new LinkedList<>();
    public String[] permutation(String s) {
        boolean[] isSearched = new boolean[s.length()];
        Arrays.fill(isSearched, false);
        dfs(s.toCharArray(), isSearched, new String(), s.length());

        Set<String> set = new HashSet<>(ans);
        return set.toArray(new String[set.size()]);
    }

    public void dfs(char[] s, boolean[] isSearched, String path, int n){
        if (path.length() == n){
            ans.add(path);
            return;
        }

        for (int i = 0; i < s.length; i ++){
            if (!isSearched[i]) {
                isSearched[i] = true;
                dfs(s, isSearched, path + s[i], n);
                isSearched[i] = false;
            }
        }
    }

    public static void main(String[] args){
        Q38 q = new Q38();
        int a = 123;
        String s = String.valueOf(a);
        String[] re = q.permutation(s);
        System.out.println(Arrays.asList(re));
    }
}
