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
    TreeNode node ;
    int idx = 0;
    Pair(TreeNode node , int idx){
        this.node = node;
        this.idx = idx;
    }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int ans = 0;
        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            int min = q.peek().idx;
            int size = q.size();
            int first = 0, last = 0;
            for(int i = 0; i < size; i++){
                int midx = q.peek().idx-min;
                TreeNode node = q.peek().node;
                q.poll();
                if(i == 0) first = midx;
                if(i == size-1) last = midx;
                if(node.left != null) q.offer(new Pair(node.left,midx*2+1));
                if(node.right != null) q.offer(new Pair(node.right,midx*2+2));
            }
            ans = Math.max(ans,last-first+1);
        }
        return ans; 
    }
}