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
    int total = 0;
    public int pathSum(TreeNode root, int targetSum) {
        total = 0;
        HashMap<Long,Integer> map = new HashMap<>();
        map.put(0L,1);
        prefixSum(root,targetSum,map,0);
        return total;
        
    }
    public void prefixSum(TreeNode root,int k ,HashMap<Long,Integer> map,long sum){
        if(root == null) return;
        sum += root.val;
        total += map.getOrDefault(sum - k, 0);
        map.put(sum,map.getOrDefault(sum,0)+1);
        prefixSum(root.left,k,map,sum);
        prefixSum(root.right,k,map,sum);
        map.put(sum,map.get(sum)-1);
        return;
    }
}