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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        inOrderTravel(root,inOrder);
        return createBalnceTree(inOrder,0,inOrder.size()-1);
    }
    public void inOrderTravel(TreeNode root,List<Integer> inOrder){
        if(root == null) return;
        inOrderTravel(root.left,inOrder);
        inOrder.add(root.val);
        inOrderTravel(root.right,inOrder);
    }
    public TreeNode createBalnceTree(List<Integer> inOrder, int st, int end){
        if(st > end) return null;
        int mid = st + (end-st)/2;
        TreeNode left = createBalnceTree(inOrder,st,mid-1);
        TreeNode right = createBalnceTree(inOrder,mid+1,end);

        TreeNode node = new TreeNode(inOrder.get(mid),left,right);
        return node;

    }
}