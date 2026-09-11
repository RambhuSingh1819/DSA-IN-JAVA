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
 class Pair{
    TreeNode node;
    int level;
    Pair(TreeNode node, int lev){
        this.node = node;
        this.level = lev;
    }
 }
class Solution {
    int Width = 0;
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return Width;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            int stIdx = q.peek().level;
            int len = q.size();
            int f = 0, l = 0;
            for(int i = 0; i < len; i++){
                Pair p = q.poll();
                TreeNode curr = p.node;
                int currIdx = p.level-stIdx;
                if(i == 0) f = currIdx;
                if(i == len -1) l = currIdx;
                if(curr.left != null) q.add(new Pair(curr.left,2*currIdx+1));
                if(curr.right != null) q.add(new Pair(curr.right,2*currIdx+2));
            }
            Width = Math.max(Width,l - f + 1);
        }
        return Width;
    }
}