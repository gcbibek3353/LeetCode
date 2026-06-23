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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null)
            return true;
        if (root == null || subRoot == null)
            return false;

        boolean currentValMatch = (root.val == subRoot.val);
        boolean TreeMatch = false;
        if (currentValMatch)
            TreeMatch = isTreeSame(root, subRoot);
        boolean subTreeExistsOnLeft = isSubtree(root.left, subRoot);
        boolean subTreeExistOnRight = isSubtree(root.right, subRoot);

        return TreeMatch || subTreeExistsOnLeft || subTreeExistOnRight;
    }

    private boolean isTreeSame(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        
        boolean curValueSame = (root1.val == root2.val);
        boolean leftSubTreesSame = isTreeSame(root1.left , root2.left);
        boolean rightSubTreesSame = isTreeSame(root1.right , root2.right);
        return curValueSame && leftSubTreesSame && rightSubTreesSame;
    }
}