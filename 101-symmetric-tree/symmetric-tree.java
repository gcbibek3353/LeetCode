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

    private boolean isMirror(TreeNode leftNode , TreeNode rightNode) {
        if(leftNode == null && rightNode == null) return true;
        if(leftNode == null || rightNode == null) return false;
        boolean cond1 = isMirror(leftNode.left , rightNode.right);
        boolean cond2 = isMirror(leftNode.right , rightNode.left);
        boolean cond3 = leftNode.val == rightNode.val;
        return (cond1 && cond2 && cond3);
    }
}