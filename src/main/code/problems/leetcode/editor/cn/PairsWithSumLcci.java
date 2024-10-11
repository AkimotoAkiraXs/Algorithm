// Design an algorithm to find all pairs of integers within an array which sum
// to a specified value.
//
// Example 1: 
//
// 
// Input: nums = [5,6,5], target = 11
// Output: [[5,6]]
//
// Example 2: 
//
// 
// Input: nums = [5,6,5,6], target = 11
// Output: [[5,6],[5,6]]
//
// Note: 
//
// 
// nums.length <= 100000 
// -10^5 <= nums[i], target <= 10^5 
// 
//
// 👍 54 👎 0

package problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * Id：&emsp;&emsp;面试题 16.24
 * <p>
 * Name：Pairs With Sum LCCI
 *
 * @author Yuri
 * @since 2024-10-11 11:53:27
 */

public class PairsWithSumLcci {

    public static void main(String[] args) {
        Solution solution = new PairsWithSumLcci().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<Integer>> pairSums(int[] nums, int target) {
            Map<Integer, Integer> hash = new HashMap<>();
            List<List<Integer>> ans = new ArrayList<>();
            for (int num : nums) {
                int key = target - num;
                if (hash.containsKey(key)) {
                    Integer val = hash.get(key);
                    if (val == 1) hash.remove(key);
                    else hash.put(key, val - 1);
                    ans.add(List.of(num, key));
                } else hash.merge(num, 1, Integer::sum);
            }
            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}