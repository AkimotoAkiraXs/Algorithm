// There is a hidden integer array arr that consists of n non-negative integers.
//
//
// It was encoded into another integer array encoded of length n - 1, such that 
// encoded[i] = arr[i] XOR arr[i + 1]. For example, if arr = [1,0,2,1], then
// encoded = [1,2,3].
//
// You are given the encoded array. You are also given an integer first, that 
// is the first element of arr, i.e. arr[0].
//
// Return the original array arr. It can be proved that the answer exists and 
// is unique.
//
// 
// Example 1: 
//
// 
// Input: encoded = [1,2,3], first = 1
// Output: [1,0,2,1]
// Explanation: If arr = [1,0,2,1], then first = 1 and encoded = [1 XOR 0, 0 XOR
// 2, 2 XOR 1] = [1,2,3]
// 
//
// Example 2: 
//
// 
// Input: encoded = [6,2,7,3], first = 4
// Output: [4,2,0,7,4]
// 
//
// 
// Constraints: 
//
// 
// 2 <= n <= 10⁴ 
// encoded.length == n - 1 
// 0 <= encoded[i] <= 10⁵ 
// 0 <= first <= 10⁵ 
// 
//
// 👍 126 👎 0

package problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * Id：&emsp;&emsp;1720
 * <p>
 * Name：Decode XORed Array
 *
 * @author Yuri
 * @since 2024-07-05 17:41:25
 */

public class DecodeXoredArray {

    public static void main(String[] args) {
        Solution solution = new DecodeXoredArray().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] decode(int[] encoded, int first) {
            int n = encoded.length + 1;
            int[] res = new int[n];
            res[0] = first;
            for (int i = 0; i < encoded.length; i++) res[i + 1] = res[i] ^ encoded[i];
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}