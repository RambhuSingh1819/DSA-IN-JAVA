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
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> post = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;
        TreeNode lastVisited = null;

        while (curr != null || !stack.isEmpty()) {

            // Go as left as possible
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            TreeNode peekNode = stack.peek();

            // If right child exists and not processed yet
            if (peekNode.right != null &&
                lastVisited != peekNode.right) {

                curr = peekNode.right;
            } else {
                post.add(peekNode.val);
                lastVisited = stack.pop();
            }
        }

        return post;
    }
}