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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        boolean rightToLeft = false;
        if(root != null) q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> curList = new ArrayList<>();
            while(size -- > 0) {
                TreeNode node = q.poll();

                if (rightToLeft)
                    curList.addFirst(node.val);
                else
                    curList.addLast(node.val);

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            ans.add(curList);
            rightToLeft = !rightToLeft;
        }
        return ans;
    }
}