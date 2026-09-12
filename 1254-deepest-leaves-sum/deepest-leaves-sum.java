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
    public int deepestLeavesSum(TreeNode root) {
        if(root == null) return 0;
        //int n = depth(root);
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int len = q.size();
            int levSum = 0;
            for(int i = 0;  i < len; i++){
                TreeNode curr = q.poll();
                levSum += curr.val;
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);    
            }
            ans = levSum;
        }
        return ans;
    }
    // public int depth(TreeNode root){
    //     if(root == null) return 0;
    //     int left = depth(root.left);
    //     int right = depth(root.right);
    //     return 1 + Math.max(left , right);
    // }
}
