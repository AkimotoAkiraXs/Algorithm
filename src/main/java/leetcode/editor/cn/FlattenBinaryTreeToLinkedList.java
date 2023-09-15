//给你二叉树的根结点 root ，请你将它展开为一个单链表： 
//
// 
// 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。 
// 展开后的单链表应该与二叉树 先序遍历 顺序相同。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,5,3,4,null,6]
//输出：[1,null,2,null,3,null,4,null,5,null,6]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 2000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？ 
// Related Topics 栈 树 深度优先搜索 链表 二叉树 
// 👍 899 👎 0


/*
 * Id：114
 * Name：二叉树展开为链表
 * Date：2021-08-31 10:10:04
 */
package leetcode.editor.cn;

import model.TreeNode;

public class FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        Solution solution = new FlattenBinaryTreeToLinkedList().new Solution();
        TreeNode treeNode = new TreeNode(new Integer[]{1, 2, 5, 3, 4, null, 6});
        solution.flatten(treeNode);
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
        //dfs前驱遍历
//        List<TreeNode> trees = new ArrayList<>();
//
//        void dfsGet(TreeNode node) {
//            if (node == null) return;
//            trees.add(node);
//            dfsGet(node.left);
//            dfsGet(node.right);
//        }
//
//        void dfs(TreeNode node) {
//            if (node == null) return;
//            node.val = trees.remove(0).val;
//            if (!trees.isEmpty()) {
//                node.right = new TreeNode();
//                node.left = null;
//                dfs(node.right);
//            }
//        }
//
//        public void flatten(TreeNode root) {
//            dfsGet(root);
//            dfs(root);
//        }

        //空间复杂度O(1) 类似mirror算法
        public void flatten(TreeNode root) {
            if (root == null) return;
            if (root.left != null) {
                TreeNode cur = root.left;
                while (cur.right != null) cur = cur.right;
                cur.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            flatten(root.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
} 