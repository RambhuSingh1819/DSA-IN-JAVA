class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int minVal) {
        if (node == null) return -1;

        // Found a value strictly greater than the tree's minimum; candidate found
        if (node.val > minVal) {
            return node.val;
        }

        // If node.val == minVal, search both left and right subtrees
        int left = dfs(node.left, minVal);
        int right = dfs(node.right, minVal);

        // If both subtrees found a candidate, take the smaller one
        if (left != -1 && right != -1) {
            return Math.min(left, right);
        }

        // Otherwise, return whichever candidate is valid (or -1 if neither)
        return left != -1 ? left : right;
    }
}