/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if((p.val == root.val) || (q.val == root.val)) return root;
        if((search(root.left, p) && search(root.right,q)) || (search(root.left, q) && search(root.right,p))) return root;
        if(search(root.left, p) && search(root.left, q)) return lowestCommonAncestor(root.left , p , q);
        else return lowestCommonAncestor(root.right, p , q);
    }

    private boolean search(TreeNode root, TreeNode target){
        if(root == null) return false;
        if(root == target) return true;
        return search(root.left,target) || search(root.right,target);
    }
}