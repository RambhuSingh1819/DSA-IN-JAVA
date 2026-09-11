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
    int ans = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return ans;
    }
    public int dfs(TreeNode root){
        if(root == null) return 0;
        int left = dfs(root.left);
        int right =dfs(root.right);

        int arrowLeft = 0;
        int arrowRight = 0;

        if(root.left != null && root.left.val == root.val){
            arrowLeft = left + 1;
        }
        if(root.right != null && root.right.val == root.val) arrowRight = right + 1;

        ans = Math.max(ans,arrowLeft + arrowRight);
        return Math.max(arrowLeft,arrowRight);
    }
}