// You are given a 2D boolean matrix grid.
//
// A collection of 3 elements of grid is a right triangle if one of its 
// elements is in the same row with another element and in the same column with the third
// element. The 3 elements may not be next to each other.
//
// Return an integer that is the number of right triangles that can be made 
// with 3 elements of grid such that all of them have a value of 1.
//
// 
// Example 1: 
//
// 
// 
// 
// 
// 0 
// 1 
// 0 
// 
// 
// 0 
// 1 
// 1 
// 
// 
// 0 
// 1 
// 0 
// 
// 
// 
// 
//
// 
// 
// 
// 0 
// 1 
// 0 
// 
// 
// 0 
// 1 
// 1 
// 
// 
// 0 
// 1 
// 0 
// 
// 
// 
//
// 
// 
// 
// 0 
// 1 
// 0 
// 
// 
// 0 
// 1 
// 1 
// 
// 
// 0 
// 1 
// 0 
// 
// 
// 
//
// 
// Input: grid = [[0,1,0],[0,1,1],[0,1,0]] 
// 
//
// Output: 2 
//
// Explanation: 
//
// There are two right triangles with elements of the value 1. Notice that the 
// blue ones do not form a right triangle because the 3 elements are in the same
// column.
//
// Example 2: 
//
// 
// 
// 
// 
// 1 
// 0 
// 0 
// 0 
// 
// 
// 0 
// 1 
// 0 
// 1 
// 
// 
// 1 
// 0 
// 0 
// 0 
// 
// 
// 
// 
//
// 
// Input: grid = [[1,0,0,0],[0,1,0,1],[1,0,0,0]] 
// 
//
// Output: 0 
//
// Explanation: 
//
// There are no right triangles with elements of the value 1. Notice that the 
// blue ones do not form a right triangle.
//
// Example 3: 
//
// 
// 
// 
// 
// 1 
// 0 
// 1 
// 
// 
// 1 
// 0 
// 0 
// 
// 
// 1 
// 0 
// 0 
// 
// 
// 
// 
//
// 
// 
// 
// 1 
// 0 
// 1 
// 
// 
// 1 
// 0 
// 0 
// 
// 
// 1 
// 0 
// 0 
// 
// 
// 
//
// 
// Input: grid = [[1,0,1],[1,0,0],[1,0,0]] 
// 
//
// Output: 2 
//
// Explanation: 
//
// There are two right triangles with elements of the value 1. 
//
// 
// Constraints: 
//
// 
// 1 <= grid.length <= 1000 
// 1 <= grid[i].length <= 1000 
// 0 <= grid[i][j] <= 1 
// 
//
// 👍 44 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;3128
 * <p>
 * Name：Right Triangles
 *
 * @author Yuri
 * @since 2024-11-08 11:34:34
 */

public class RightTriangles {

    public static void main(String[] args) {
        Solution solution = new RightTriangles().new Solution();
        solution.numberOfRightTriangles(new int[][]{{0, 1, 0}, {0, 1, 1}, {0, 1, 0}});
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 根据low中的乘法原理，每个grid[i][j]=1的位置所贡献的值是：所在i行1的个数-1 乘以 所在j列1的个数-1
         */
        public long numberOfRightTriangles(int[][] grid) {
            long ans = 0;
            int m = grid.length, n = grid[0].length;
            var col = new int[n];
            for (int i = 0; i < n; i++) {
                col[i] = -1;
                for (int[] g : grid) col[i] += g[i];
            }

            for (var g : grid) {
                int row = -1;
                for (var k : g) row += k;
                for (int i = 0; i < n; i++)
                    if (g[i] == 1) ans += (long) row * col[i];
            }
            return ans;
        }

        /**
         * 利用前后缀和，记录(i,j)四个方向上1的个数，根据题意利用乘法原理，当(i,j)为1时，其能贡献的直角三角形个数就是：横向1的个数 * 竖向1的个数
         */
        public long numberOfRightTriangles_low(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            var cnt = new int[4][m][n];
            var dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    int k = 0;
                    int x = i + dir[k][0], y = j + dir[k][1];
                    if (x >= 0 && x < m && y >= 0 && y < n) cnt[k][i][j] = cnt[k][x][y] + grid[x][y];

                    k = 2;
                    x = i + dir[k][0];
                    y = j + dir[k][1];
                    if (x >= 0 && x < m && y >= 0 && y < n) cnt[k][i][j] = cnt[k][x][y] + grid[x][y];
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int k = 1;
                    int x = i + dir[k][0], y = j + dir[k][1];
                    if (x >= 0 && x < m && y >= 0 && y < n) cnt[k][i][j] = cnt[k][x][y] + grid[x][y];

                    k = 3;
                    x = i + dir[k][0];
                    y = j + dir[k][1];
                    if (x >= 0 && x < m && y >= 0 && y < n) cnt[k][i][j] = cnt[k][x][y] + grid[x][y];
                }
            }

            long ans = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) continue;
                    int row = 0, column = 0;
                    for (int k = 0; k < 2; k++) row += cnt[k][i][j];
                    for (int k = 2; k < 4; k++) column += cnt[k][i][j];
                    ans += (long) row * column;
                }
            }

            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}