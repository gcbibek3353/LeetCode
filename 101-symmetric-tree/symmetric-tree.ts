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

const isMirror = (leftNode : TreeNode , rightNode : TreeNode) => {
    if(leftNode === null) return rightNode === null;
    if(rightNode === null) return leftNode === null;
    if(leftNode.val !== rightNode.val) return false;
    const leftCheck = isMirror(leftNode.left , rightNode.right);
    const rightCheck = isMirror(leftNode.right , rightNode.left);
    return leftCheck && rightCheck;
}