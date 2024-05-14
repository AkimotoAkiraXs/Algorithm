// There are k workers who want to move n boxes from an old warehouse to a new
// one. You are given the two integers n and k, and a 2D integer array time of size
// k x 4 where time[i] = [leftToRighti, pickOldi, rightToLefti, putNewi].
//
// The warehouses are separated by a river and connected by a bridge. The old 
// warehouse is on the right bank of the river, and the new warehouse is on the left
// bank of the river. Initially, all k workers are waiting on the left side of the
// bridge. To move the boxes, the iᵗʰ worker (0-indexed) can :
//
// 
// Cross the bridge from the left bank (new warehouse) to the right bank (old 
// warehouse) in leftToRighti minutes.
// Pick a box from the old warehouse and return to the bridge in pickOldi 
// minutes. Different workers can pick up their boxes simultaneously.
// Cross the bridge from the right bank (old warehouse) to the left bank (new 
// warehouse) in rightToLefti minutes.
// Put the box in the new warehouse and return to the bridge in putNewi minutes.
// Different workers can put their boxes simultaneously. 
// 
//
// A worker i is less efficient than a worker j if either condition is met: 
//
// 
// leftToRighti + rightToLefti > leftToRightj + rightToLeftj 
// leftToRighti + rightToLefti == leftToRightj + rightToLeftj and i > j 
// 
//
// The following rules regulate the movement of the workers through the bridge :
// 
//
// 
// If a worker x reaches the bridge while another worker y is crossing the 
// bridge, x waits at their side of the bridge.
// If the bridge is free, the worker waiting on the right side of the bridge 
// gets to cross the bridge. If more than one worker is waiting on the right side,
// the one with the lowest efficiency crosses first.
// If the bridge is free and no worker is waiting on the right side, and at 
// least one box remains at the old warehouse, the worker on the left side of the
// river gets to cross the bridge. If more than one worker is waiting on the left side,
// the one with the lowest efficiency crosses first.
// 
//
// Return the instance of time at which the last worker reaches the left bank 
// of the river after all n boxes have been put in the new warehouse.
//
// 
// Example 1: 
//
// 
// Input: n = 1, k = 3, time = [[1,1,2,1],[1,1,3,1],[1,1,4,1]]
// Output: 6
// Explanation:
// From 0 to 1: worker 2 crosses the bridge from the left bank to the right bank.
//
// From 1 to 2: worker 2 picks up a box from the old warehouse.
// From 2 to 6: worker 2 crosses the bridge from the right bank to the left bank.
//
// From 6 to 7: worker 2 puts a box at the new warehouse.
// The whole process ends after 7 minutes. We return 6 because the problem asks
// for the instance of time at which the last worker reaches the left bank.
// 
//
// Example 2: 
//
// 
// Input: n = 3, k = 2, time = [[1,9,1,8],[10,10,10,10]]
// Output: 50
// Explanation:
// From 0  to 10: worker 1 crosses the bridge from the left bank to the right
// bank.
// From 10 to 20: worker 1 picks up a box from the old warehouse.
// From 10 to 11: worker 0 crosses the bridge from the left bank to the right
// bank.
// From 11 to 20: worker 0 picks up a box from the old warehouse.
// From 20 to 30: worker 1 crosses the bridge from the right bank to the left
// bank.
// From 30 to 40: worker 1 puts a box at the new warehouse.
// From 30 to 31: worker 0 crosses the bridge from the right bank to the left
// bank.
// From 31 to 39: worker 0 puts a box at the new warehouse.
// From 39 to 40: worker 0 crosses the bridge from the left bank to the right
// bank.
// From 40 to 49: worker 0 picks up a box from the old warehouse.
// From 49 to 50: worker 0 crosses the bridge from the right bank to the left
// bank.
// From 50 to 58: worker 0 puts a box at the new warehouse.
// The whole process ends after 58 minutes. We return 50 because the problem
// asks for the instance of time at which the last worker reaches the left bank.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n, k <= 10⁴ 
// time.length == k 
// time[i].length == 4 
// 1 <= leftToRighti, pickOldi, rightToLefti, putNewi <= 1000 
// 
//
// 👍 36 👎 0

package leetcode.editor.cn;

import cn.hutool.core.lang.Pair;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * Id：&emsp;&emsp;2532
 * <p>
 * Name：Time to Cross a Bridge
 *
 * @author Yuri
 * @since 2023-07-07 09:43:32
 */


public class TimeToCrossABridge {
    public static void main(String[] args) {
        Solution solution = new TimeToCrossABridge().new Solution();
        int crossingTime = solution.findCrossingTime(9, 6, new int[][]{{2, 6, 9, 4}, {4, 8, 7, 5}, {4, 6, 7, 6}, {2, 3, 3, 7}, {9, 3, 6, 8}, {2, 8, 8, 4}});
        System.out.println(crossingTime);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 自己做的2589分的模拟题，理清逻辑和运动顺序不难
         * <p>
         * 题意说有箱子工人才能从左桥头过桥，所以我们定义每当一个工人过桥就减少一个箱子。
         * 还有个细节地方是，我们定义到达仓库瞬间即可以拿到箱子或者放下箱子，而time[1]、time[3]只是工人跑回桥头的时间。
         * 对应答案求的最后一个工人到达左边桥头时间其实就是求最后一个箱子被放下的瞬间。
         */
        public int findCrossingTime(int n, int k, int[][] time) {
            int t = 0;
            PriorityQueue<Integer> waitLeft = new PriorityQueue<>((x, y) -> {
                if ((time[x][0] + time[x][2]) - (time[y][0] + time[y][2]) == 0) return y - x;
                return (time[y][0] + time[y][2]) - (time[x][0] + time[x][2]);
            });
            PriorityQueue<Integer> waitRight = new PriorityQueue<>(waitLeft);
            PriorityQueue<Pair<Integer, Integer>> runLeft = new PriorityQueue<>(Comparator.comparingInt(Pair::getValue));
            PriorityQueue<Pair<Integer, Integer>> runRight = new PriorityQueue<>(Comparator.comparingInt(Pair::getValue));
            for (int i = 0; i < k; i++) waitLeft.add(i);
            while (n > 0 || !waitRight.isEmpty() || !runRight.isEmpty()) {
                if (!waitRight.isEmpty()) {
                    Integer i = waitRight.poll();
                    t += time[i][2];
                    runLeft.add(new Pair<>(i, t + time[i][3]));
                } else if (!waitLeft.isEmpty() && n > 0) {
                    Integer i = waitLeft.poll();
                    t += time[i][0];
                    runRight.add(new Pair<>(i, t + time[i][1]));
                    n--;
                } else {
                    if (!runRight.isEmpty() && !runLeft.isEmpty())
                        t = Math.min(runRight.peek().getValue(), Objects.requireNonNull(runLeft.peek()).getValue());
                    else if (!runRight.isEmpty()) t = runRight.peek().getValue();
                    else if (!runLeft.isEmpty()) t = runLeft.peek().getValue();
                }
                while (!runRight.isEmpty() && runRight.peek().getValue() <= t)
                    waitRight.add(Objects.requireNonNull(runRight.poll()).getKey());
                while (!runLeft.isEmpty() && runLeft.peek().getValue() <= t)
                    waitLeft.add(Objects.requireNonNull(runLeft.poll()).getKey());
            }
            return t;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
