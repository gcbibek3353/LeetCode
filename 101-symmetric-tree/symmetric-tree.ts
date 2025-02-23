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

function isSymmetric(root: TreeNode | null): boolean {
    return isMirror(root,root);
};
function isMirror(left : TreeNode | null , right : TreeNode | null){
    if(left === null && right === null) return true;
    else if ((left !== null && right === null) || (left === null && right !== null)) return false;
    else return left.val === right.val && isMirror(left.left,right.right) && isMirror(left.right,right.left);
}