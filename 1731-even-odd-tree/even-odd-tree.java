class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            int prev = (level % 2 == 0) ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                if (level % 2 == 0) {
                    // even level: odd + increasing
                    if (node.val % 2 == 0) return false;
                    if (node.val <= prev) return false;
                } else {
                    // odd level: even + decreasing
                    if (node.val % 2 != 0) return false;
                    if (node.val >= prev) return false;
                }

                prev = node.val;

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }

            level++;
        }

        return true;
    }
}