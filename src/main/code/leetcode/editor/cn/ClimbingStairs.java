// 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
// 输出： 2
// 解释： 有两种方法可以爬到楼顶。
// 1.  1 阶 + 1 阶
// 2.  2 阶
//
// 示例 2： 
//
// 输入： 3
// 输出： 3
// 解释： 有三种方法可以爬到楼顶。
// 1.  1 阶 + 1 阶 + 1 阶
// 2.  1 阶 + 2 阶
// 3.  2 阶 + 1 阶
// 
// Related Topics 记忆化搜索 数学 动态规划 
// 👍 1918 👎 0


/*
 * Id：70
 * Name：爬楼梯
 * Date：2021-10-08 09:27:12
 */
package leetcode.editor.cn;

public class ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new ClimbingStairs().new Solution();
        System.out.println("Hello world");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 时间复杂度O(n)
        public int climbStairs(int n) {
            int p, q = 0, r = 1;
            for (int i = 1; i <= n; i++) {
                p = q;
                q = r;
                r = p + q;
            }
            return r;
        }

        public int climbStairs_Dfs(int n) {
            if (n <= 2) return n;
            return climbStairs_Dfs(n - 1) + climbStairs_Dfs(n - 2);
        }

        // 斐波那契数列的通项公式
        public int climbStairs_Math(int n) {
            double sqrt5 = Math.sqrt(5);
            double fn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
            return (int) Math.round(fn / sqrt5);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)
} 