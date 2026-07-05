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
    int ans;
    public int sumNumbers(TreeNode root) {
        count(root , 0);
        return ans;
    }

    private void count(TreeNode root , int curDigit) {
        if(root == null) return;
        int curNum = curDigit * 10 + root.val;
        if(root.left == null && root.right == null) ans += curNum;
        else{
            if(root.left != null) count(root.left , curNum);
            if(root.right != null) count(root.right , curNum);
        }
    }
}