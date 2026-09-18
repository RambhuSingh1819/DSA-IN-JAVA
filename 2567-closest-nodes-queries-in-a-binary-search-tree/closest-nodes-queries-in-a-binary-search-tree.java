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
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        int n = queries.size();
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        List<List<Integer>> ans = new ArrayList<>();
        for(int ele : queries){
            ans.add(bs(list,ele));
        }
        return ans;
        
    }
    public void inorder(TreeNode node, List<Integer> list){
        if(node == null) return;
        inorder(node.left,list);
        list.add(node.val);
        inorder(node.right,list);
    }
    public List<Integer> bs(List<Integer> list, int k){
        int high = list.size()-1;
        int low = 0;
        int ceil = -1,flor = -1;
        while(low <= high){
            int mid = low + (high- low)/2;
            int ele = list.get(mid);
            if(ele == k){
                return Arrays.asList(ele, ele);
            }else if(ele > k){
                ceil = ele;
                high = mid-1;
            }else{
                flor = ele;
                low = mid+1;
            }
        }
        return Arrays.asList(flor, ceil);
    }
}