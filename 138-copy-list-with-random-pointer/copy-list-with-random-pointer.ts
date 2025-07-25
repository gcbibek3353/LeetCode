/**
 * Definition for _Node.
 * class _Node {
 *     val: number
 *     next: _Node | null
 *     random: _Node | null
 * 
 *     constructor(val?: number, next?: _Node, random?: _Node) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.next = (next===undefined ? null : next)
 *         this.random = (random===undefined ? null : random)
 *     }
 * }
 */


function copyRandomList(head: _Node | null): _Node | null {
    let temp = head;
    let mp = new Map<_Node | null , _Node | null>();

    while(temp !== null) {
        let newNode = new _Node(temp.val);
        mp.set(temp , newNode);
        temp = temp.next;
    }
    console.log(mp);

    temp = head;
    while(temp !== null) {
        let copyNode = mp.get(temp) || null;
        copyNode.next = mp.get(temp.next) || null;
        copyNode.random = mp.get(temp.random);
        temp = temp.next;
    }

    return mp.get(head);
};