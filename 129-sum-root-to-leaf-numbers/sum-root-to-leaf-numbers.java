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
    int totalSum = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        solve(root,0); 
        return totalSum; 
    }
    public void solve(TreeNode node, int ans){
        if(node == null) {
            return;
        }
        ans = (ans * 10 ) + node.val;
        if(node.left == null && node.right == null){
            totalSum += ans;
            return;
        }
        solve(node.left, ans);
        solve(node.right, ans);
    }
}