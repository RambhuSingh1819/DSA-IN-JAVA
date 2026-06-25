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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(postorder,0,postorder.length - 1,inorder,0,inorder.length - 1,map);
    }

    public TreeNode build(int[] postorder,int pStart,int pEnd,int[] inorder,int iStart,int iEnd,Map<Integer, Integer> map) {

        if (pStart > pEnd || iStart > iEnd)
            return null;

        TreeNode root = new TreeNode(postorder[pEnd]);

        int inRoot = map.get(root.val);
        int numsLeft = inRoot - iStart;

        root.left = build(postorder,pStart,pStart + numsLeft - 1,inorder,iStart,inRoot - 1,map);
        root.right = build(postorder,pStart + numsLeft,pEnd - 1,inorder,inRoot + 1,iEnd,map);

        return root;
    }
}