package 数据结构.Graph;
import java.util.*;
public class Q127单词接龙 {

    /*
    字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列：

    序列中第一个单词是 beginWord 。
    序列中最后一个单词是 endWord 。
    每次转换只能改变一个字母。
    转换过程中的中间单词必须是字典 wordList 中的单词。
    给你两个单词 beginWord 和 endWord 和一个字典 wordList ，找到从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/word-ladder
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    Map<String, Set<String>> map; // 创建邻接表  String -> 邻居String的映射
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (! wordList.contains(endWord))
            return 0;

        this.map = new HashMap<>();

        wordList.add(beginWord);
        for (String word : wordList)
            map.put(word, new HashSet<String>());

        constructGraph(wordList);
//        for (String word : map.keySet())
//            System.out.println(map.get(word).size());
        return bfs(beginWord, endWord, new HashSet<String>());
    }

    private int bfs(String beginWord, String target, Set<String> visit){
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int path = 0;

        while (q.size() != 0){
            int m = q.size();
            path ++;
            while (m > 0){
                String pop = q.poll();
                visit.add(pop);
                if (pop.equals(target))
                    return path;
                for (String nei : map.get(pop)){
                    if (! visit.contains(nei))
                        q.add(nei);
                }
                m --;
            }
        }
        return path;
    }

    private void constructGraph(List<String> wordList){
        for (int i = 0; i < wordList.size(); i ++){
            for (int j = 0; j < wordList.size(); j ++){
                if (i == j)
                    continue;
                String s = wordList.get(i);
                String t = wordList.get(j);
                if (isOneWordVar(s, t)){
                    map.get(s).add(t);
                    map.get(t).add(s);
                }
            }
        }
    }

    private boolean isOneWordVar(String s, String t){
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n; i ++){
            if (s.charAt(i) != t.charAt(i))
                count ++;
        }
        return count == 1;
    }




    List<String> wordList;
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        if (! wordList.contains(endWord))
            return 0;

        int n = wordList.size();
        this.wordList = wordList;
        wordList.add(beginWord);
        return bfs2(beginWord, endWord, new HashSet<String>());
    }

    private int bfs2(String beginWord, String target, Set<String> visit){
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        visit.add(beginWord);
        int path = 0;

        while (q.size() != 0){
            int m = q.size();
            path ++;
            while (m > 0){
                String pop = q.poll();
                if (oneWordVar(pop, target, q, visit))
                    return path + 1;
                m --;
            }
        }
        return 0;
    }

    private boolean oneWordVar(String curWord, String target, Queue<String> q, Set<String> visit){
        char[] charArr = curWord.toCharArray();
        for (int i = 0; i < charArr.length; i ++){
            char c = charArr[i];
            for (char j = 'a'; j <= 'z'; j ++){
                if (j == c)
                    continue;
                charArr[i] = j;
                String nextWord = String.valueOf(charArr);
                if (wordList.contains(nextWord)){
                    if (target.equals(nextWord))
                        return true;
                    if (! visit.contains(nextWord)){
                        q.offer(nextWord);
                        visit.add(nextWord);
                    }
                }
            }
            charArr[i] = c;
        }
        return false;
    }

    public static void main(String[] args){
        List<String> wordList = new LinkedList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        Q127单词接龙 q = new Q127单词接龙();
        int r = q.ladderLength("hit", "cog", wordList);
        System.out.println("ans : " + r);
    }
}
