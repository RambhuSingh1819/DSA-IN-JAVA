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
    int sum = 0;
    public int sumEvenGrandparent(TreeNode root) {
        if(root == null) return 0;
        check(root);
        return sum;
    }
    public void solve(TreeNode node){
        if(node.left != null){
            TreeNode leftPar = node.left;
            if(leftPar.left != null) sum += leftPar.left.val;
            if(leftPar.right != null) sum += leftPar.right.val;
        }
        if(node.right != null){
            TreeNode rightPar = node.right;
            if(rightPar.left != null) sum += rightPar.left.val;
            if(rightPar.right != null) sum += rightPar.right.val;
        }
    }
    public void check(TreeNode root){
        if(root == null) return;
        if(root.val % 2 == 0) solve(root);
        check(root.left);
        check(root.right);
    }
}