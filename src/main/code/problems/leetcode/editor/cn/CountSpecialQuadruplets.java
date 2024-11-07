// Given a 0-indexed integer array nums, return the number of distinct
// quadruplets (a, b, c, d) such that:
//
// 
// nums[a] + nums[b] + nums[c] == nums[d], and 
// a < b < c < d 
// 
//
// 
// Example 1: 
//
// 
// Input: nums = [1,2,3,6]
// Output: 1
// Explanation: The only quadruplet that satisfies the requirement is (0, 1, 2, 3
//) because 1 + 2 + 3 == 6.
// 
//
// Example 2: 
//
// 
// Input: nums = [3,3,6,4,5]
// Output: 0
// Explanation: There are no such quadruplets in [3,3,6,4,5].
// 
//
// Example 3: 
//
// 
// Input: nums = [1,1,1,3,5]
// Output: 4
// Explanation: The 4 quadruplets that satisfy the requirement are:
//- (0, 1, 2, 3): 1 + 1 + 1 == 3
//- (0, 1, 3, 4): 1 + 1 + 3 == 5
//- (0, 2, 3, 4): 1 + 1 + 3 == 5
//- (1, 2, 3, 4): 1 + 1 + 3 == 5
// 
//
// 
// Constraints: 
//
// 
// 4 <= nums.length <= 50 
// 1 <= nums[i] <= 100 
// 
//
// 👍 139 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;1995
 * <p>
 * Name：Count Special Quadruplets
 *
 * @author Yuri
 * @since 2024-11-07 11:12:28
 */

public class CountSpecialQuadruplets {

    public static void main(String[] args) {
        Solution solution = new CountSpecialQuadruplets().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)

    /**
     * O(n^4)，纯暴力（略）
     * <p>
     * O(n^3)，哈希表统计d频次
     * <p>
     * O(n^2)，哈希表统计d-c的频次
     * <p>
     * O(n*110*4)，多维背包（略）
     */
    class Solution {

        public int countQuadruplets_n3(int[] nums) {
            var cnt = new int[301];
            int n = nums.length, ans = 0;
            for (int c = n - 2; c >= 2; c--) {
                cnt[nums[c + 1]]++;
                for (int a = 0; a < c; a++) {
                    for (int b = a + 1; b < c; b++) {
                        ans += cnt[nums[a] + nums[b] + nums[c]];
                    }
                }
            }
            return ans;
        }

        public int countQuadruplets(int[] nums) {
            var cnt = new int[1001];
            int ans = 0, n = nums.length, os = 200; // os是偏移量
            for (int b = n - 3; b >= 0; b--) {
                int c = b + 1;
                for (int d = b + 2; d < n; d++) cnt[nums[d] - nums[c] + os]++;
                for (int a = 0; a < b; a++) ans += cnt[nums[a] + nums[b] + os];
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}