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
    public int maxLevelSum(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int maxSum = root.val;
        int ansLevel = 1;
        int curLevel = 1;
        while(!queue.isEmpty()){
            int curQueueSize = queue.size();
            int curSum = 0; 
            for(int i = 0; i < curQueueSize; i ++){
                TreeNode curElm = queue.poll();
                curSum += curElm.val;
                if(curElm.left != null)queue.add(curElm.left);
                if(curElm.right != null) queue.add(curElm.right);
            }
            if(curSum > maxSum){
                maxSum = curSum;
                ansLevel = curLevel;
            }
            curLevel ++;
        }
        return ansLevel;
    }
}