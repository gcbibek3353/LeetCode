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

function isSameTree(p: TreeNode | null, q: TreeNode | null): boolean {
if((p === null && q !== null) || (p !== null && q === null)) return false;
else if (p === null && q === null) return true;
const isLeftSame = isSameTree(p.left,q.left);
const isRightSame = isSameTree(p.right,q.right);
return isLeftSame && isRightSame && p.val === q.val;
};