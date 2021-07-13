import java.util.*;

public class T {
    List<String> ans = new ArrayList<>();
    public String[] permutation(String s) {
        if (s == null || s.length() == 0)
            return new String[]{};
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        s = new String(arr);
        int n = s.length();
        boolean[] visit = new boolean[n];
        dfs(s, "", n, visit);
        String[] ansStr = new String[ans.size()];
        for (int i = 0; i < ans.size(); i ++)
            ansStr[i] = ans.get(i);
        return ansStr;
    }

    private void dfs(String s, String path, int n, boolean[] visit){
        if (path.length() == n){
            ans.add(path);
            return;
        }

        for (int i = 0; i < n; i ++){
            if (!visit[i]){
                if (i >= 1 && s.charAt(i) == s.charAt(i - 1) && visit[i - 1] == false)
                    continue;

                visit[i] = true;
                dfs(s, path + String.valueOf(s.charAt(i)), n, visit);
                visit[i] = false;
            }
        }
    }
}
