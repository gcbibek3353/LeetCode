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
        if(inorder.length == 0 || postorder.length == 0) return null;
        int indexOfRoot = findIndex(inorder , postorder[postorder.length - 1]);
        TreeNode root = new TreeNode(inorder[indexOfRoot]);
        root.left = buildTree(Arrays.copyOfRange(inorder , 0 , indexOfRoot) , Arrays.copyOfRange(postorder , 0 , indexOfRoot));
        root.right = buildTree(Arrays.copyOfRange(inorder , indexOfRoot + 1 , inorder.length) , Arrays.copyOfRange(postorder , indexOfRoot , postorder.length - 1));
        return root;
    }

    private int findIndex(int[] inorder , int value){
        int i;
        for( i = 0; i < inorder.length; i ++){
            if(inorder[i] == value) return i;
        }
        return i;
    }
}