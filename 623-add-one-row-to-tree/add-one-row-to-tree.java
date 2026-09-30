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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode prev = new TreeNode(val);
            prev.left = root;
            return prev;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int lev = 1;
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len; i++){
                TreeNode curr = q.poll();
                if(lev == depth-1){
                    TreeNode cL = curr.left;
                    TreeNode cR = curr.right;

                    curr.left = new TreeNode(val);
                    curr.left.left = cL;

                    curr.right = new TreeNode(val);
                    curr.right.right = cR;
                }else {
                    if(curr.left != null) q.add(curr.left);
                    if(curr.right != null) q.add(curr.right);
                }
                
            } 
            if(lev == depth-1) break;
            lev++;
        }
        return root;       
    }
}