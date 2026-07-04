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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 && inorder.length == 0) return null;

        TreeNode root = new TreeNode(preorder[0]);
        int indexOfRoot = findIndex(inorder , root.val);
        root.left = buildTree(Arrays.copyOfRange(preorder , 1 , indexOfRoot + 1) , Arrays.copyOfRange(inorder , 0 , indexOfRoot));
        root.right = buildTree(Arrays.copyOfRange(preorder , indexOfRoot + 1 , preorder.length), Arrays.copyOfRange(inorder , indexOfRoot + 1 , inorder.length));
        return root;
    }
    private int findIndex(int[] arr , int target){
        int ans = -1;
        for(int i = 0; i < arr.length; i ++) if(arr[i] == target) return i;
        return ans;
    }
}