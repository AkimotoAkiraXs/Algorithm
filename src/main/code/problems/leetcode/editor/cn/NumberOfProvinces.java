//
// 
// 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连
//。 
//
// 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。 
//
// 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 
//isConnected[i][j] = 0 表示二者不直接相连。 
//
// 返回矩阵中 省份 的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 200 
// n == isConnected.length 
// n == isConnected[i].length 
// isConnected[i][j] 为 1 或 0 
// isConnected[i][i] == 1 
// isConnected[i][j] == isConnected[j][i] 
// 
// 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 图 👍 795 👎 0


package problems.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Id：&emsp;&emsp;547
 * <p>
 * Name：省份数量
 *
 * @author Yuri
 * @since 2022-06-01 16:37:31
 */
public class NumberOfProvinces {
    public static void main(String[] args) {
        Solution solution = new NumberOfProvinces().new Solution();
        int circleNum = solution.findCircleNum(new int[][]{{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}});
        System.out.println("ans:"+circleNum);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findCircleNum(int[][] isConnected) {
            int n = isConnected.length;
            int ans = 0;
            boolean[] flag = new boolean[n];
            for (int i = 0; i < n; i++) {
                if (flag[i]) {
                    continue;
                }
                ans++;
                flag[i] = true;
                Queue<Integer> queue = new ArrayDeque<>();
                for (int j = 0; j < n; j++) {
                    if (flag[j] || isConnected[i][j] == 0) {
                        continue;
                    }
                    queue.add(j);
                }
                while (!queue.isEmpty()) {
                    Integer num = queue.remove();
                    if (flag[num]) {
                        continue;
                    }
                    flag[num] = true;
                    for (int j = 0; j < n; j++) {
                        if (flag[j] || isConnected[num][j] == 0) {
                            continue;
                        }
                        queue.add(j);
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}