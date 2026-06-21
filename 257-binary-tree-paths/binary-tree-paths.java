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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();

        dfs(root, path, ans);
        return ans;
    }

    void dfs(TreeNode node, List<String> path, List<String> ans) {
        if (node == null) return;
        path.add(String.valueOf(node.val));

        if (node.left == null && node.right == null) {
            ans.add(String.join("->", path));
        }

        dfs(node.left, path, ans);
        dfs(node.right, path, ans);
        path.remove(path.size() - 1);
    }
}