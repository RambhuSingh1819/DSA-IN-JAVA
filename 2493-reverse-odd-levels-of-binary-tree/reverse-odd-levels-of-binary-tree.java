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
    public TreeNode reverseOddLevels(TreeNode root) {
        // if (root == null) return root;

        // Queue<TreeNode> q = new ArrayDeque<>();
        // q.offer(root);
        // int level = 0;

        // while (!q.isEmpty()) {
        //     int size = q.size();
        //     List<TreeNode> list = new ArrayList<>();

        //     for (int i = 0; i < size; i++) {
        //         TreeNode node = q.poll();

        //         if (level % 2 == 1) {
        //             list.add(node);
        //         }

        //         if (node.left != null) q.offer(node.left);
        //         if (node.right != null) q.offer(node.right);
        //     }

        //     int l = 0, r = list.size() - 1;
        //     while (l < r) {
        //         int temp = list.get(l).val;
        //         list.get(l).val = list.get(r).val;
        //         list.get(r).val = temp;
        //         l++;
        //         r--;
        //     }

        //     level++;
        // }

        // return root;

        if(root == null) return null;
        dfs(root.left,root.right,1);
        return root;


    }
    public void dfs(TreeNode lNode, TreeNode rNode,int level){
        if(lNode == null || rNode == null) return ;
        if(level % 2 != 0){
            int temp = lNode.val;
            lNode.val = rNode.val;
            rNode.val = temp;
        }
        dfs(lNode.left,rNode.right,level+1);
        dfs(lNode.right,rNode.left,level+1);
    }
}