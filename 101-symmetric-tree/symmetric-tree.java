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
    public boolean isSymmetric(TreeNode root) {
    return root == null || isMirrorValue(root.left,root.right);    
    }
    public boolean isMirrorValue(TreeNode left, TreeNode right){
        if(left == null || right == null) return left == right;
        if(left.val != right.val) return false;
        return isMirrorValue(left.left,right.right )&& isMirrorValue(left.right, right.left);
    }
}