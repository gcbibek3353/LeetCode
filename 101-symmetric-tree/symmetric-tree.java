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
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left , root.right);
    }

    private boolean isMirror(TreeNode leftChild , TreeNode rightChild) {
        if(leftChild == null && rightChild == null) return true;
        if(leftChild == null || rightChild == null) return false;
        boolean condition1 = leftChild.val == rightChild.val;
        boolean condition2 = isMirror(leftChild.left , rightChild.right);
        boolean condition3 = isMirror(leftChild.right , rightChild.left);
        return condition1 && (condition2 && condition3);
    }
}