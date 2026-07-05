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
    List<Integer> leaves = new ArrayList<>();
    boolean isSimilarTree = true;
    int index = 0;

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        dfs1(root1);
        dfs2(root2);
        return isSimilarTree && index == leaves.size();
    }

    private void dfs1(TreeNode root1) {
        if (root1 == null)
            return;
        if (root1.left == null && root1.right == null) {
            leaves.add(root1.val);
            return;
        }
        if (root1.left != null)
            dfs1(root1.left);
        if (root1.right != null)
            dfs1(root1.right);
    }

    private void dfs2(TreeNode root2) {
        if (root2 == null)
            return;
        if(index == leaves.size()){
            isSimilarTree = false;
            return;
        }
        if (root2.left == null && root2.right == null) {
            if(root2.val != leaves.get(index)) isSimilarTree = false;
            index ++;
            return;
        }
        if (root2.left != null)
            dfs2(root2.left);
        if (root2.right != null)
            dfs2(root2.right);
    }

}