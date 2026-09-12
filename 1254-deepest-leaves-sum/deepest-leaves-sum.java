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
    public int deepestLeavesSum(TreeNode root) {
        if(root == null) return 0;
        int n = depth(root);
        int ans = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int lev = 0;
        while(!q.isEmpty()){
            lev++;
            int len = q.size();
            for(int i = 0;  i < len; i++){
                TreeNode curr = q.poll();
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
                if(lev == n){
                    ans += curr.val;
                }
            }
        }
        return ans;
    }
    public int depth(TreeNode root){
        if(root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        return 1 + Math.max(left , right);
    }
}
