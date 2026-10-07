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
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        if(n == 0) return null;
        if(n == 1) return new TreeNode(nums[0]);
        return solve(nums,0,nums.length-1); 
    }
    public TreeNode solve(int[] nums, int st, int end){
        if(st > end) return null;
        int mid = st + (end - st )/2;
        TreeNode left = solve(nums,st,mid-1);
        TreeNode right = solve(nums,mid+1,end);

        TreeNode node = new TreeNode(nums[mid],left,right);
        return node;
    }
}