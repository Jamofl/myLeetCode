package BackTrack回溯;

/*
    980. 不同路径 III
    在二维网格 grid 上，有 4 种类型的方格：

    1 表示起始方格。且只有一个起始方格。
    2 表示结束方格，且只有一个结束方格。
    0 表示我们可以走过的空方格。
    -1 表示我们无法跨越的障碍。
    返回在四个方向（上、下、左、右）上行走时，从起始方格到结束方格的不同路径的数目。

    每一个无障碍方格都要通过一次，但是一条路径中不能重复通过同一个方格。
 */
public class Q980不同路径3 {
    public int ans = 0;
    public int[] X = new int[] {-1, 0, 1, 0};
    public int[] Y = new int[] {0, 1, 0, -1};
    public int row;
    public int col;
    public int uniquePathsIII(int[][] grid) {
        this.row = grid.length;
        this.col = grid[0].length;
        int remain = 0;
        int srcI = 0;
        int srcJ = 0;
        int targetI = 0;
        int targetJ = 0;
        for (int i = 0; i < row; i ++){
            for (int j = 0; j < col; j ++){
                if (grid[i][j] == 0)
                    remain ++;
                if (grid[i][j] == 1){
                    srcI = i;
                    srcJ = j;
                }
                if (grid[i][j] == 2){
                    targetI = i;
                    targetJ = j;
                }
            }
        }
        dfs(remain, grid, srcI, srcJ, targetI, targetJ);
        return ans;
    }

    public void dfs(int remain, int[][] grid, int i, int j, int targetI, int targetJ){
        if (i == targetI && j== targetJ && remain ==  -1){
            ans += 1;
            return;
        }

        // 上下左右 四邻域
        for (int k = 0; k <= 3; k ++){
            int newI = i + Y[k];
            int newJ = j + X[k];
            if (newI >= 0 && newI < row && newJ >= 0 && newJ < col && (
                    grid[newI][newJ] == 0 || grid[newI][newJ] == 2)){
                grid[newI][newJ] = 3; // 3表示正在访问
                dfs(remain - 1, grid, newI, newJ, targetI, targetJ);
                grid[newI][newJ] = 0;
            }
        }
    }

    public static void main(String[] args){
        Q980不同路径3 q = new Q980不同路径3();
        int[][] gird = new int[][] {{1, 0 ,0 ,0}, {0,0,0,0}, {0,0,0,2}};
        System.out.println(q.uniquePathsIII(gird));
    }
}
