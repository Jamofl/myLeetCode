package 数据结构.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Q两数之间的最小距离 {
        /*
    计算器只支持 -1 操作和 *2 操作，初始值x和目标值y，最少通过几步可以从x到y
     */

    // 图的解法
    public static void main(String[] args){
        System.out.println(minStep(1,7));
    }


    public static int minStep(int src, int target) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        int step = 0;
        while (queue.size() > 0){
            int m = queue.size();
            while (m > 0){
                int pop = queue.poll();
                if (pop == target)
                    return step;
                queue.offer(pop - 1);
                queue.offer(pop * 2);
                m --;
            }
            step ++;
        }
        return -1;
    }
}

