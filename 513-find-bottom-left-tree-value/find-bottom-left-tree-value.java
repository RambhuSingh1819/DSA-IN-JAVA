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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> dq = new LinkedList<>();
        dq.add(root);
        TreeNode nod = null;
        while(!dq.isEmpty()){
            nod = dq.poll();
            if(nod.right != null) dq.add(nod.right);
            if(nod.left != null) dq.add(nod.left);
        }
        return nod.val;
    }
}