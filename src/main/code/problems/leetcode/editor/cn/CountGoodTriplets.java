// Given an array of integers arr, and three integers a, b and c. You need to
// find the number of good triplets.
//
// A triplet (arr[i], arr[j], arr[k]) is good if the following conditions are 
// true:
//
// 
// 0 <= i < j < k < arr.length 
// |arr[i] - arr[j]| <= a 
// |arr[j] - arr[k]| <= b 
// |arr[i] - arr[k]| <= c 
// 
//
// Where |x| denotes the absolute value of x. 
//
// Return the number of good triplets. 
//
// 
// Example 1: 
//
// 
// Input: arr = [3,0,1,1,9,7], a = 7, b = 2, c = 3
// Output: 4
// Explanation: There are 4 good triplets: [(3,0,1), (3,0,1), (3,1,1), (0,1,1)].
// 
//
// Example 2: 
//
// 
// Input: arr = [1,1,2,2,3], a = 0, b = 0, c = 1
// Output: 0
// Explanation: No triplet satisfies all conditions.
// 
//
// 
// Constraints: 
//
// 
// 3 <= arr.length <= 100 
// 0 <= arr[i] <= 1000 
// 0 <= a, b, c <= 1000 
// 
//
// 👍 85 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;1534
 * <p>
 * Name：Count Good Triplets
 *
 * @author Yuri
 * @since 2024-10-11 14:46:10
 */

public class CountGoodTriplets {

    public static void main(String[] args) {
        Solution solution = new CountGoodTriplets().new Solution();
        solution.countGoodTriplets(new int[]{3, 0, 1, 1, 9, 7}, 7, 2, 3);
    }

    // leetcode submit region begin(Prohibit modification and deletion)

    class Solution {

        /**
         * 暴力（略）
         * <p>
         * O(n^2)的做法：因为出现的数只包含0~1000，所以枚举一对<=b的数，然后统计包含这对数的三元组中的第三个数的范围，
         * 答案只需要加上范围内出现数频次即可。为避免重复计算，频次只统计i之前的数。
         */
        public int countGoodTriplets(int[] arr, int a, int b, int c) {
            int ans = 0;
            var sum = new int[1001]; // sum[arr[i]]记录的是，在arr数组0~i的数中<=arr[i]数出现的频次
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (Math.abs(arr[i] - arr[j]) <= b) {
                        int la = arr[i] - a, ra = arr[i] + a;
                        int lc = arr[j] - c, rc = arr[j] + c;
                        int l = Math.max(0, Math.max(la, lc)), r = Math.min(1000, Math.min(ra, rc));
                        if (l <= r) {
                            if (l == 0) ans += sum[r];
                            else ans += sum[r] - sum[l - 1];
                        }
                    }
                }
                for (int j = arr[i]; j <= 1000; j++) sum[j]++;
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}