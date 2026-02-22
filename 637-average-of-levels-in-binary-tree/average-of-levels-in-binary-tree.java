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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if(root != null)q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            double n = (double)size;
            double curSum = 0.0;
            while(size -- > 0){
                TreeNode curNode = q.poll();
                curSum += curNode.val;
                if(curNode.left != null) q.offer(curNode.left);
                if(curNode.right != null) q.offer(curNode.right);
            }
            double curAns = curSum / n;
            ans.add(curAns);
        }
        return ans;
    }
}