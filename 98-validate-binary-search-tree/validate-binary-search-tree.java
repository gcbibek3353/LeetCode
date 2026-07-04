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
    public boolean isValidBST(TreeNode root) {
        return helper(root , Long.MIN_VALUE , Long.MAX_VALUE);
    }

    private boolean helper(TreeNode root , long leftBoundary , long rightBoundary){
        if(root == null) return true;
        boolean leftIsValid = helper(root.left , leftBoundary , root.val);
        boolean rightIsValid = helper(root.right , root.val , rightBoundary);
        boolean curIsValid = (root.val > leftBoundary && root.val < rightBoundary);
        if( curIsValid && (leftIsValid && rightIsValid)) return true;
        return false;
    }
}