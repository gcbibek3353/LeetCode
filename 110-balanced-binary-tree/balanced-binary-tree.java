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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int leftChildDepth = findDepth(root.left);
        int rightChildDepth = findDepth(root.right);
        boolean curNodeBalanced = false;
        if(Math.abs(leftChildDepth - rightChildDepth) <= 1) curNodeBalanced = true;
        boolean leftNodeBalanced = isBalanced(root.left);
        boolean rightNodeBalanced = isBalanced(root.right);
        return (leftNodeBalanced && rightNodeBalanced) && curNodeBalanced;
    }

    private int findDepth(TreeNode root){
        if(root == null) return 0;
        int leftDepth = findDepth(root.left);
        int rightDepth = findDepth(root.right);
        return 1 + Math.max(leftDepth , rightDepth);
    }
}