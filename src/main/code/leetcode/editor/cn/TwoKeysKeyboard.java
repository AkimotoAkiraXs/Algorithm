// There is only one character 'A' on the screen of a notepad. You can perform
// one of two operations on this notepad for each step:
//
// 
// Copy All: You can copy all the characters present on the screen (a partial 
// copy is not allowed).
// Paste: You can paste the characters which are copied last time. 
// 
//
// Given an integer n, return the minimum number of operations to get the 
// character 'A' exactly n times on the screen.
//
// 
// Example 1: 
//
// 
// Input: n = 3
// Output: 3
// Explanation: Initially, we have one character 'A'.
// In step 1, we use Copy All operation.
// In step 2, we use Paste operation to get 'AA'.
// In step 3, we use Paste operation to get 'AAA'.
// 
//
// Example 2: 
//
// 
// Input: n = 1
// Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 1000 
// 
//
// Related Topics 数学 动态规划 👍 507 👎 0

package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;650
 * <p>
 * Name：2 Keys Keyboard
 *
 * @author Yuri
 * @since 2023-05-11 16:57:38
 */


public class TwoKeysKeyboard {
    public static void main(String[] args) {
        Solution solution = new TwoKeysKeyboard().new Solution();
        solution.minSteps(2);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSteps(int n) {
            int cnt = 0;
            for (int i = 2; i * i <= n; i++) {
                while (n % i == 0) {
                    cnt += i;
                    n /= i;
                }
            }
            if (n > 1) {
                cnt += n;
            }
            return cnt;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
