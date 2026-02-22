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
        Queue<TreeNode> q = new LinkedList<>();

        if(root != null) q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> curList = new ArrayList<>();
            while(size -- > 0) {
                TreeNode curNode = q.poll();
                curList.add(curNode.val);
                if(curNode.left != null) q.offer(curNode.left);
                if(curNode.right != null) q.offer(curNode.right);
            }
            ans.add(curList);
        }
        return ans;
    }
}