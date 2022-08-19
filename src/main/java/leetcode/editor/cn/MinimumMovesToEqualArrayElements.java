//给你一个长度为 n 的整数数组，每次操作将会使 n - 1 个元素增加 1 。返回让数组所有元素相等的最小操作次数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：3
//解释：
//只需要3次操作（注意每次操作会增加两个元素的值）：
//[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 答案保证符合 32-bit 整数 
// 
//
// Related Topics 数组 数学 👍 474 👎 0


package leetcode.editor.cn;

/**
 * Id：&emsp;&emsp;453
 * <p>
 * Name：最小操作次数使数组元素相等
 *
 * @author Yuri
 * @since 2022-08-19 10:29:28
 */
public class MinimumMovesToEqualArrayElements {
    public static void main(String[] args) {
        Solution solution = new MinimumMovesToEqualArrayElements().new Solution();
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minMoves(int[] nums) {
            int min = Integer.MAX_VALUE;
            int tot = 0;
            for (int num : nums) {
                if (min > num) min = num;
                tot += num;
            }
            return tot - min * nums.length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}