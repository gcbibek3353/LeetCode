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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;        

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()){
            int curQueueSize = q.size();
            List<Integer> curAns = new ArrayList<>();
            for(int i = 0; i <curQueueSize; i ++) {
                TreeNode curElm = q.poll();
                if(curElm == null) continue;
                if(curElm.left != null) q.offer(curElm.left);
                if(curElm.right != null) q.offer(curElm.right);
                curAns.add(curElm.val);
            }
            ans.add(curAns);
        }
        return ans;
    }
}