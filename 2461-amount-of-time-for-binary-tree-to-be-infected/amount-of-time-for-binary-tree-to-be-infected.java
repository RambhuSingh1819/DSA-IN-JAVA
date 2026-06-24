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

    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();

        TreeNode startNode = buildParent(root, parent, start);

        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        q.offer(startNode);
        visited.add(startNode);

        int time = -1;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                if (curr.left != null && visited.add(curr.left)) {
                    q.offer(curr.left);
                }

                if (curr.right != null && visited.add(curr.right)) {
                    q.offer(curr.right);
                }

                TreeNode par = parent.get(curr);

                if (par != null && visited.add(par)) {
                    q.offer(par);
                }
            }

            time++;
        }

        return time;
    }

    private TreeNode buildParent(
            TreeNode root,
            Map<TreeNode, TreeNode> parent,
            int start) {

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        TreeNode startNode = null;

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            if (curr.val == start) {
                startNode = curr;
            }

            if (curr.left != null) {
                parent.put(curr.left, curr);
                q.offer(curr.left);
            }

            if (curr.right != null) {
                parent.put(curr.right, curr);
                q.offer(curr.right);
            }
        }

        return startNode;
    }
}