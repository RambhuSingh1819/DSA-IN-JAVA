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
    public void parent_child(Map<TreeNode , TreeNode> map , TreeNode root){
       if(root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.left != null){
                q.offer(curr.left);
                map.put(curr.left,curr);
            }
            if(curr.right != null) {
                map.put(curr.right,curr);
                q.offer(curr.right);
            }
            
        }
    }

    public int amountOfTime(TreeNode root, int start) {
        int cnt = -1;
        TreeNode target = rootIs(root,start);
        if(target == null) return cnt;
        Map<TreeNode , TreeNode > p_t = new HashMap<>();
        parent_child(p_t,root);
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        visited.add(target);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size;i++){
                TreeNode curr = q.poll();

                if(curr.left != null && !visited.contains(curr.left)){
                    q.offer(curr.left);
                    visited.add(curr.left);
                }
                if(curr.right != null && !visited.contains(curr.right)){
                    q.offer(curr.right);
                    visited.add(curr.right);
                }
                if(p_t.get(curr) != null && !visited.contains(p_t.get(curr))){
                    q.offer(p_t.get(curr));
                    visited.add(p_t.get(curr));
                }
            }
            cnt++;
        }
        return cnt;   
    }
    public TreeNode rootIs(TreeNode root,int start){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.val == start) return curr;
            if(curr.left != null){
                q.offer(curr.left);
            }
            if(curr.right != null) q.offer(curr.right);
        }
        return null;
    }
}