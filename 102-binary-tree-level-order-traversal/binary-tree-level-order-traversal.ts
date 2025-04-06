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

function levelOrder(root: TreeNode | null): number[][] {
    let level = 0;
    const mp = new Map<number,number[]>();
    let ans = new Array<number[]>();

    const traverse = (root : TreeNode | null) => {
        if(root === null) return;
        if(mp.has(level)) mp.get(level).push(root.val)
        else mp.set(level , [root.val]);
        level ++;
        traverse(root.left);
        traverse(root.right);
        level --;
    }
    traverse(root);
    // console.log(mp);

    for(let [level,value] of mp){
        ans.push(value);
    }

    return ans;
};