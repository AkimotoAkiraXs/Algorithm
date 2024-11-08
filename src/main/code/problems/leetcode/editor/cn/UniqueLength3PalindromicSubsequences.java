// Given a string s, return the number of unique palindromes of length three
// that are a subsequence of s.
//
// Note that even if there are multiple ways to obtain the same subsequence, it 
// is still only counted once.
//
// A palindrome is a string that reads the same forwards and backwards. 
//
// A subsequence of a string is a new string generated from the original string 
// with some characters (can be none) deleted without changing the relative order
// of the remaining characters.
//
// 
// For example, "ace" is a subsequence of "abcde". 
// 
//
// 
// Example 1: 
//
// 
// Input: s = "aabca"
// Output: 3
// Explanation: The 3 palindromic subsequences of length 3 are:
//- "aba" (subsequence of "aabca")
//- "aaa" (subsequence of "aabca")
//- "aca" (subsequence of "aabca")
// 
//
// Example 2: 
//
// 
// Input: s = "adc"
// Output: 0
// Explanation: There are no palindromic subsequences of length 3 in "adc".
// 
//
// Example 3: 
//
// 
// Input: s = "bbcbaba"
// Output: 4
// Explanation: The 4 palindromic subsequences of length 3 are:
//- "bbb" (subsequence of "bbcbaba")
//- "bcb" (subsequence of "bbcbaba")
//- "bab" (subsequence of "bbcbaba")
//- "aba" (subsequence of "bbcbaba")
// 
//
// 
// Constraints: 
//
// 
// 3 <= s.length <= 10⁵ 
// s consists of only lowercase English letters. 
// 
//
// 👍 47 👎 0

package problems.leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;1930
 * <p>
 * Name：Unique Length-3 Palindromic Subsequences
 *
 * @author Yuri
 * @since 2024-11-08 10:59:07
 */

public class UniqueLength3PalindromicSubsequences {

    public static void main(String[] args) {
        Solution solution = new UniqueLength3PalindromicSubsequences().new Solution();
        solution.countPalindromicSubsequence("aabca");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int countPalindromicSubsequence(String s) {
            char[] cs = s.toCharArray();
            int n = cs.length, ans = 0;
            int[] pre = new int[n], suf = new int[n]; // 用二进制压缩26个字符，前后缀表示i位置为止是否出现过某个字符
            pre[0] = 1 << (cs[0] - 'a');
            suf[n - 1] = 1 << (cs[n - 1] - 'a');
            for (int i = 1; i < n; i++) pre[i] = pre[i - 1] | (1 << (cs[i] - 'a'));
            for (int i = n - 2; i >= 0; i--) suf[i] = suf[i + 1] | (1 << (cs[i] - 'a'));
            var f = new boolean[26][26]; // 记录回文是否存在
            for (int i = 1; i < n - 1; i++) {
                for (int j = 0; j < 26; j++) {
                    if (!f[cs[i] - 'a'][j] && (pre[i - 1] & (1 << j)) > 0 && (suf[i + 1] & (1 << j)) > 0) {
                        ans++;
                        f[cs[i] - 'a'][j] = true;
                    }
                }
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}