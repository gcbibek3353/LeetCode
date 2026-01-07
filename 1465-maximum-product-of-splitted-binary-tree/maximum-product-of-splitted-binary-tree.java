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
     static final int MOD = 1_000_000_007;
    ArrayList<Integer> sums = new ArrayList<>();
    public int maxProduct(TreeNode root) {
        long totalSum = treeSum(root);
        long max_value = 0;
        for(int sum : sums) {
            long complimentSum = totalSum - sum;
            long product = sum * complimentSum;
            max_value = Math.max(max_value , product);
        }
        return (int)(max_value % MOD);
    }

    private int treeSum(TreeNode root) {
        if(root == null) return 0;
        int leftSum = treeSum(root.left);
        int rightSum = treeSum(root.right);
        int curSum = leftSum + rightSum + root.val;
        sums.add(curSum);
        return curSum;
    }
}