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

function countNodes(root: TreeNode | null): number {
      if(root === null) return 0;
    let leftCount = countNodes(root.left);
    let rightCount = countNodes(root.right);
    return leftCount + rightCount + 1;
};
// function count(root : TreeNode | null) : number{
//     if(root === null) return 0;
//     let leftCount = count(root.left);
//     let rightCount = count(root.right);
//     return leftCount + rightCount + 1;
// }