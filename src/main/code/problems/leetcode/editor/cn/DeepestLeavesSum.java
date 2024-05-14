//给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
//输出：15
// 
//
// 示例 2： 
//
// 
//输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
//输出：19
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 10⁴] 之间。 
// 1 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 106 👎 0


package problems.leetcode.editor.cn;


import model.TreeNode;

/**
 * Id：&emsp;&emsp;1302
 * <p>
 * Name：层数最深叶子节点的和
 *
 * @author Yuri
 * @since 2022-08-17 10:18:58
 */
public class DeepestLeavesSum {
    public static void main(String[] args) {
        Solution solution = new DeepestLeavesSum().new Solution();
        int i = solution.deepestLeavesSum(new TreeNode(new Integer[]{1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8}));
        System.out.println("i: " + i);
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */

    class Solution {
        int[] sum = new int[100];

        public int deepestLeavesSum(TreeNode root) {
            dfs(root, 0);
            int k = sum.length;
            while (sum[--k] == 0) ;
            return sum[k];
        }

        void dfs(TreeNode node, int degree) {
            if (node.left != null) {
                dfs(node.left, degree + 1);
            }
            if (node.right != null) {
                dfs(node.right, degree + 1);
            }
            sum[degree] += node.val;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}