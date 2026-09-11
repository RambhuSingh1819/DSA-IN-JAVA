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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        int ans  = Integer.MIN_VALUE;
        int lev = -1;
        while(!q.isEmpty()){
            int n = q.size();
            level++;
            int sum = 0;
            for(int i = 0; i < n; i++){
                TreeNode curr = q.poll();
                sum = sum + curr.val;
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            if(sum > ans){
                lev = level;
                ans = sum;
            } 
        }
        return lev;
    }
}