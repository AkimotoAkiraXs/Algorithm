// Given the head of a linked list head, in which each node contains an integer
// value.
//
// Between every pair of adjacent nodes, insert a new node with a value equal 
// to the greatest common divisor of them.
//
// Return the linked list after insertion. 
//
// The greatest common divisor of two numbers is the largest positive integer 
// that evenly divides both numbers.
//
// 
// Example 1: 
// 
// 
// Input: head = [18,6,10,3]
// Output: [18,6,6,2,10,1,3]
// Explanation: The 1ˢᵗ diagram denotes the initial linked list and the 2ⁿᵈ
// diagram denotes the linked list after inserting the new nodes (nodes in blue are the
// inserted nodes).
//- We insert the greatest common divisor of 18 and 6 = 6 between the 1ˢᵗ and 
// the 2ⁿᵈ nodes.
//- We insert the greatest common divisor of 6 and 10 = 2 between the 2ⁿᵈ and 
// the 3ʳᵈ nodes.
//- We insert the greatest common divisor of 10 and 3 = 1 between the 3ʳᵈ and 
// the 4ᵗʰ nodes.
// There are no more adjacent nodes, so we return the linked list.
// 
//
// Example 2: 
// 
// 
// Input: head = [7]
// Output: [7]
// Explanation: The 1ˢᵗ diagram denotes the initial linked list and the 2ⁿᵈ
// diagram denotes the linked list after inserting the new nodes.
// There are no pairs of adjacent nodes, so we return the initial linked list.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [1, 5000]. 
// 1 <= Node.val <= 1000 
// 
//
// 👍 1 👎 0

package problems.leetcode.editor.cn;

import model.ListNode;

/**
 * Id：&emsp;&emsp;2807
 * <p>
 * Name：Insert Greatest Common Divisors in Linked List
 *
 * @author Yuri
 * @since 2023-08-07 19:19:32
 */


public class InsertGreatestCommonDivisorsInLinkedList {
    public static void main(String[] args) {
        Solution solution = new InsertGreatestCommonDivisorsInLinkedList().new Solution();

    }

    // leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode insertGreatestCommonDivisors(ListNode head) {
            ListNode node = head;
            while (node.next != null) {
                int gcd = gcd(node.val, node.next.val);
                ListNode nn = new ListNode(gcd, node.next);
                node.next = nn;
                node = nn.next;
            }
            return head;
        }

        int gcd(int a, int b) {
            if (b > a) {
                int temp = a;
                a = b;
                b = temp;
            }
            if (b == 0) return a;
            return gcd(b, a % b);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

} 
