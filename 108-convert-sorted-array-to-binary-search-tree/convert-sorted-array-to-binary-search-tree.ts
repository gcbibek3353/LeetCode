/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     val: number
 *     left: TreeNode | null
 *     right: TreeNode | null
 *     constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.left = (left===undefined ? null : left)
 *         this.right = (right===undefined ? null : right)
 *     }
 * }
 */

function sortedArrayToBST(nums: number[]): TreeNode | null {
  if(nums.length === 0) return null;
   const midIndex = Math.floor(nums.length / 2);
   const curValue = nums[midIndex];
   
   return new TreeNode(
    curValue,
    sortedArrayToBST(nums.slice(0,midIndex)),
    sortedArrayToBST(nums.slice(midIndex + 1))
    )
}
      