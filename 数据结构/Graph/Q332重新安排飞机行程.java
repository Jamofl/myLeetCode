package ���ݽṹ.Graph;
/*
332. ���°����г�
����һ����Ʊ���ַ�����ά���� [from, to]���������е�������Ա�ֱ��ʾ�ɻ������ͽ���Ļ����ص㣬�Ը��г̽������¹滮����������Щ��Ʊ������һ���� JFK������Ϲ��ʻ��������������������Ը��г̱���� JFK ��ʼ��

��ʾ��

������ڶ�����Ч���г̣����㰴�ַ���Ȼ���򷵻���С���г���ϡ����磬�г� ["JFK", "LGA"] �� ["JFK", "LGB"] ��Ⱦ͸�С���������ǰ
���еĻ�������������д��ĸ��ʾ���������룩��
�ٶ����л�Ʊ���ٴ���һ�ֺ�����г̡�
���еĻ�Ʊ���붼��һ�� �� ֻ����һ�Ρ�

ʾ�� 1��

���룺[["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
�����["JFK", "MUC", "LHR", "SFO", "SJC"]

ʾ�� 2��

���룺[["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
�����["JFK","ATL","JFK","SFO","ATL","SFO"]
���ͣ���һ����Ч���г��� ["JFK","SFO","ATL","JFK","ATL","SFO"]����������Ȼ������������
 */
import java.util.*;
import java.util.List;

public class Q332���°��ŷɻ��г� {

    public Map<String, PriorityQueue<String>> adjacent = new HashMap<>();
    public List<String> ans = new LinkedList<>();


    // ά��һ��PQ��ÿ�ζ��ȵ����ֵ�����С���Ǹ��ھӽڵ�
    // dfs������ͼ������dfs��������Ľ����Ȼ�󽫸ý������
    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets){
            String src = ticket.get(0);
            String dst = ticket.get(1);
            if (adjacent.getOrDefault(src, null) == null){
                PriorityQueue<String> nei = new PriorityQueue<>();
                nei.add(dst);
                adjacent.put(src, nei);
            }
            else
                adjacent.get(src).add(dst);
        }
        dfs("S");
        Collections.reverse(ans);
        return ans;
    }

    private void dfs(String cur){
        while (adjacent.containsKey(cur) && adjacent.get(cur).size() > 0) {
            String temp = adjacent.get(cur).poll();
            dfs(temp);
        }
        ans.add(cur);
    }

    public static void main(String[] args){
        Q332���°��ŷɻ��г� q = new Q332���°��ŷɻ��г�();
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(List.of("S", "B"));
        tickets.add(List.of("B", "S"));
        tickets.add(List.of("S", "A"));
        List<String> ans = q.findItinerary(tickets);
        System.out.println(ans.toString());
    }

}
