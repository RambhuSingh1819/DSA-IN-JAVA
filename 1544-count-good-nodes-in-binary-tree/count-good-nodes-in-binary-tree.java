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
    int cnt = 0;
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        solve(root,root.val);
        return cnt;    
    }
    public void solve(TreeNode root,int ele){
        if(root == null) return;
        if(root.val >= ele) {
            ele = root.val;
            cnt++;
        }
        solve(root.left,ele);
        solve(root.right,ele);
    }
}