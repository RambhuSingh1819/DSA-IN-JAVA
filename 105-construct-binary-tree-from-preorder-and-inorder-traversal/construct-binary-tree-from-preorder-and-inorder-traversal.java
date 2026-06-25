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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }
        TreeNode root = buildDiffTree(preorder,0,preorder.length-1, 
                                       inorder,0,inorder.length-1,map);
        return root;
    }
    public TreeNode  buildDiffTree(int[] preorder, int pStart, int pEnd,
                                    int[] inorder, int iStart , int iEnd,
                                    Map<Integer,Integer> imap)
    {
        if(pStart > pEnd || iStart > iEnd) return null;
        TreeNode root = new TreeNode(preorder[pStart]);
        int inRoot = imap.get(root.val);
        int numLeft = inRoot-iStart;
        root.left = buildDiffTree(preorder,pStart+1,pStart+numLeft,inorder,iStart, inRoot-1,imap);
        root.right = buildDiffTree(preorder,pStart+numLeft+1,pEnd,inorder,inRoot+1, iEnd,imap);
        
    return root;
    }
}