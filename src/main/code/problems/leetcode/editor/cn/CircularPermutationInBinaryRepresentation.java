// Given 2 integers n and start. Your task is return any permutation p of (0,1,2.
//....,2^n -1) such that : 
//
// 
// p[0] = start 
// p[i] and p[i+1] differ by only one bit in their binary representation. 
// p[0] and p[2^n -1] must also differ by only one bit in their binary 
// representation.
// 
//
// 
// Example 1: 
//
// 
// Input: n = 2, start = 3
// Output: [3,2,0,1]
// Explanation: The binary representation of the permutation is (11,10,00,01).
// All the adjacent element differ by one bit. Another valid permutation is [3,1,
// 0,2]
// 
//
// Example 2: 
//
// 
// Input: n = 3, start = 2
// Output: [2,6,7,5,4,0,1,3]
// Explanation: The binary representation of the permutation is (010,110,111,101,
// 100,000,001,011).
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 16 
// 0 <= start < 2 ^ n 
// 
//
// 👍 142 👎 0

package problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * Id：&emsp;&emsp;1238
 * <p>
 * Name：Circular Permutation in Binary Representation
 *
 * @author Yuri
 * @since 2024-08-12 11:27:51
 */

public class CircularPermutationInBinaryRepresentation {

    public static void main(String[] args) {
        Solution solution = new CircularPermutationInBinaryRepresentation().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 格雷码特性是每一位只差一位数，题目要求从start开始，所以直接异或start不改变每一位只差一位数的性质
         *
         * @see GrayCode 格雷码
         */
        public List<Integer> circularPermutation(int n, int start) {
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < 1 << n; i++) ans.add(i ^ (i >> 1) ^ start);
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}