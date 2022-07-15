//设计一个包含一些单词的特殊词典，并能够通过前缀和后缀来检索单词。 
//
// 实现 WordFilter 类： 
//
// 
// WordFilter(string[] words) 使用词典中的单词 words 初始化对象。 
// f(string pref, string suff) 返回词典中具有前缀 prefix 和后缀 suff 的单词的下标。如果存在不止一个满足要求的下标，
//返回其中 最大的下标 。如果不存在这样的单词，返回 -1 。 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["WordFilter", "f"]
//[[["apple"]], ["a", "e"]]
//输出
//[null, 0]
//解释
//WordFilter wordFilter = new WordFilter(["apple"]);
//wordFilter.f("a", "e"); // 返回 0 ，因为下标为 0 的单词：前缀 prefix = "a" 且 后缀 suff = "e" 。
//
// 
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 10⁴ 
// 1 <= words[i].length <= 7 
// 1 <= pref.length, suff.length <= 7 
// words[i]、pref 和 suff 仅由小写英文字母组成 
// 最多对函数 f 执行 10⁴ 次调用 
// 
// Related Topics 设计 字典树 字符串 👍 116 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * Id：&emsp;&emsp;745
 * <p>
 * Name：前缀和后缀搜索
 *
 * @author Yuri
 * @since 2022-07-14 10:03:47
 */
public class PrefixAndSuffixSearch {
    public static void main(String[] args) {
        WordFilter solution = new PrefixAndSuffixSearch().new WordFilter();
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class WordFilter {
        Map<String, Integer> map = new HashMap<>();

        public WordFilter() {
        }

        public WordFilter(String[] words) {
            for (int i = 0; i < words.length; i++) {
                for (int j = 1; j <= words[i].length(); j++) {
                    for (int k = 1; k <= words[i].length(); k++) {
                        map.put(words[i].substring(0, j) + " " + words[i].substring(words[i].length() - k), i);
                    }
                }
            }
        }

        public int f(String pref, String suff) {

            return map.getOrDefault(pref + " " + suff, -1);
        }
    }

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */
//leetcode submit region end(Prohibit modification and deletion)

}