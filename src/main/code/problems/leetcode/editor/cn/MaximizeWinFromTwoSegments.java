// There are some prizes on the X-axis. You are given an integer array
// prizePositions that is sorted in non-decreasing order, where prizePositions[i] is the
// position of the iᵗʰ prize. There could be different prizes at the same position on
// the line. You are also given an integer k.
//
// You are allowed to select two segments with integer endpoints. The length of 
// each segment must be k. You will collect all prizes whose position falls within
// at least one of the two selected segments (including the endpoints of the
// segments). The two selected segments may intersect.
//
// 
// For example if k = 2, you can choose segments [1, 3] and [2, 4], and you 
// will win any prize i that satisfies 1 <= prizePositions[i] <= 3 or 2 <=
// prizePositions[i] <= 4.
// 
//
// Return the maximum number of prizes you can win if you choose the two 
// segments optimally.
//
// 
// Example 1: 
//
// 
// Input: prizePositions = [1,1,2,2,3,3,5], k = 2
// Output: 7
// Explanation: In this example, you can win all 7 prizes by selecting two
// segments [1, 3] and [3, 5].
// 
//
// Example 2: 
//
// 
// Input: prizePositions = [1,2,3,4], k = 0
// Output: 2
// Explanation: For this example, one choice for the segments is [3, 3] and [4, 4
//], and you will be able to get 2 prizes. 
// 
//
// 
// Constraints: 
//
// 
// 1 <= prizePositions.length <= 10⁵ 
// 1 <= prizePositions[i] <= 10⁹ 
// 0 <= k <= 10⁹ 
// prizePositions is sorted in non-decreasing order. 
// 
//
// 
// 
//
// 👍 103 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;2555
 * <p>
 * Name：Maximize Win From Two Segments
 *
 * @author Yuri
 * @since 2024-09-29 16:14:28
 */

public class MaximizeWinFromTwoSegments {

    public static void main(String[] args) {
        Solution solution = new MaximizeWinFromTwoSegments().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 滑动窗口：mid表示第二条线段的左端点，同时也是第一条线段的右端点，mx记录第一条线段在0~mid（不含）的线段中最多可以拿多少个奖品，
         * 不能先算第一条线段，再算第二条，否则mid处奖品会被重复计算。
         */
        public int maximizeWin(int[] prizePositions, int k) {
            int n = prizePositions.length;
            int ans = 0;
            for (int mid = 0, l = 0, r = 0, mx = 0; mid < n; mid++) {
                while (r < n && prizePositions[r] - prizePositions[mid] <= k) r++;
                ans = Math.max(ans, mx + r - mid);
                while (prizePositions[mid] - prizePositions[l] > k) l++;
                mx = Math.max(mx, mid - l + 1);
            }
            return ans;
        }
    }

// leetcode submit region end(Prohibit modification and deletion)

}