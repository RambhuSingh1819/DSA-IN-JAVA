/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode node, int targetSum) {
        if(node == null) return false;
        if(node.left == null && node.right == null) return  targetSum == node.val;
        return  hasPathSum(node.left,targetSum-node.val) || hasPathSum(node.right,targetSum-node.val);
    }
}