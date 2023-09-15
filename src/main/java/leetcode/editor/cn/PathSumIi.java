//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：[[5,4,11,2],[5,8,4,5]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,3], targetSum = 5
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], targetSum = 0
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点总数在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
// 
// 
// Related Topics 树 深度优先搜索 回溯 二叉树 
// 👍 563 👎 0


/*
 * Id：113
 * Name：路径总和 II
 * Date：2021-08-31 09:17:17
 */
package leetcode.editor.cn;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumIi {
    public static void main(String[] args) {
        Solution solution = new PathSumIi().new Solution();
        TreeNode treeNode = new TreeNode(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1});
        solution.pathSum(treeNode, 22);
        System.out.println("Hello world");
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

        List<List<Integer>> ans = new ArrayList<>();
        int sum;

        void dfs(TreeNode node, List<Integer> nums) {
            if (node == null) return;
            nums.add(node.val);
            if (node.left == null && node.right == null && (nums.stream().reduce(Integer::sum).orElse(0)) == sum) {
                ans.add(new ArrayList<>(nums));
                nums.remove(nums.size() - 1);
                return;
            }
            dfs(node.left, nums);
            dfs(node.right, nums);
            nums.remove(nums.size() - 1);
        }

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            sum = targetSum;
            dfs(root, new ArrayList<>());
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
} 