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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        List<Integer> temp = new ArrayList<>();
        pathSumEqualTarget(root,ans,temp,targetSum);
        return ans;
    }
    public void pathSumEqualTarget(TreeNode root,List<List<Integer>> ans,List<Integer> temp, int target) {

        if(root == null) return;

        target -= root.val;
        temp.add(root.val);

        if(root.left == null && root.right == null && target == 0) {

            ans.add(new ArrayList<>(temp));
        }

        pathSumEqualTarget(root.left, ans, temp, target);
        pathSumEqualTarget(root.right, ans, temp, target);

        temp.remove(temp.size() - 1);
    }
}