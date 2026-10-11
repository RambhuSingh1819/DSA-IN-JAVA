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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null) return null;
        TreeNode temp = solve(root,target);
        return temp;
    }
    public TreeNode solve(TreeNode node, int k){
        if(node == null) return null;
        node.left = solve(node.left,k);
        node.right = solve(node.right,k);
        if(isLeaf(node) && node.val == k){
            return null;
        }
        return node;
    }
    public boolean isLeaf(TreeNode node){
        if(node.left == null && node.right == null) return true ;
        return false;
    }
}