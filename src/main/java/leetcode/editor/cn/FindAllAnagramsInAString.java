//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 898 👎 0


package leetcode.editor.cn;

import java.util.*;

/**
 * Id：&emsp;&emsp;438
 * <p>
 * Name：找到字符串中所有字母异位词
 *
 * @author Yuri
 * @since 2022-05-26 16:45:05
 */
public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> anagrams = solution.findAnagrams(s, p);
        System.out.println(anagrams.toString());
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> ans = new ArrayList<>();
            if (s.length() < p.length()) {
                return ans;
            }
            Map<Character, Integer> sMap = new HashMap<>();
            Map<Character, Integer> pMap = new HashMap<>();
            for (int i = 0; i < p.length(); i++) {
                sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
                pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0) + 1);
            }
            if (compareMap(pMap, sMap)) {
                ans.add(0);
            }
            for (int i = p.length(); i < s.length(); i++) {
                char c = s.charAt(i - p.length());
                if (c != s.charAt(i)) {
                    Integer num = sMap.get(c);
                    if (num == 1) sMap.remove(c);
                    else sMap.put(c, num - 1);
                    sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
                }
                if (compareMap(pMap, sMap)) {
                    ans.add(i - p.length() + 1);
                }
            }
            return ans;
        }

        private boolean compareMap(Map<Character, Integer> map1, Map<Character, Integer> map2) {
            for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
                if (!Objects.equals(entry.getValue(), map2.get(entry.getKey()))) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}