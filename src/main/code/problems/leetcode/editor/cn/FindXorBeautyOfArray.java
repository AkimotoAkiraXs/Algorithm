// You are given a 0-indexed integer array nums.
//
// The effective value of three indices i, j, and k is defined as ((nums[i] | 
// nums[j]) & nums[k]).
//
// The xor-beauty of the array is the XORing of the effective values of all the 
// possible triplets of indices (i, j, k) where 0 <= i, j, k < n.
//
// Return the xor-beauty of nums. 
//
// Note that: 
//
// 
// val1 | val2 is bitwise OR of val1 and val2. 
// val1 & val2 is bitwise AND of val1 and val2. 
// 
//
// 
// Example 1: 
//
// 
// Input: nums = [1,4]
// Output: 5
// Explanation:
// The triplets and their corresponding effective values are listed below:
//- (0,0,0) with effective value ((1 | 1) & 1) = 1
//- (0,0,1) with effective value ((1 | 1) & 4) = 0
//- (0,1,0) with effective value ((1 | 4) & 1) = 1
//- (0,1,1) with effective value ((1 | 4) & 4) = 4
//- (1,0,0) with effective value ((4 | 1) & 1) = 1
//- (1,0,1) with effective value ((4 | 1) & 4) = 4
//- (1,1,0) with effective value ((4 | 4) & 1) = 0
//- (1,1,1) with effective value ((4 | 4) & 4) = 4 
// Xor-beauty of array will be bitwise XOR of all beauties = 1 ^ 0 ^ 1 ^ 4 ^ 1 ^
// 4 ^ 0 ^ 4 = 5.
//
// Example 2: 
//
// 
// Input: nums = [15,45,20,2,34,35,5,44,32,30]
// Output: 34
// Explanation: The xor-beauty of the given array is 34.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 
//
// 👍 31 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;2527
 * <p>
 * Name：Find Xor-Beauty of Array
 *
 * @author Yuri
 * @since 2024-07-10 17:49:43
 */

public class FindXorBeautyOfArray {

    public static void main(String[] args) {
        Solution solution = new FindXorBeautyOfArray().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 01x肯定会和10x异或相消，所以只有xxx这种会留下来，而xxx=x
        public int xorBeauty(int[] nums) {
            int k = 0;
            for (int num : nums) k ^= num;
            return k;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}