/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<int[]> criticalPoints = new ArrayList<>();

        ListNode prev = head;
        ListNode cur = head.next;
        ListNode next = cur.next;
        int curIndex = 1;
        while(prev != null && cur != null && next != null) {
            if(cur.val < prev.val && cur.val < next.val) {
                int[] curPoint = {cur.val , curIndex};
                criticalPoints.add(curPoint);
            }
            else if(cur.val > prev.val && cur.val > next.val) {
                int[] curPoint = {cur.val , curIndex};
                criticalPoints.add(curPoint);
            }
            prev = cur;
            cur = next;
            next = next.next;
            curIndex ++;
        }

        for(int i = 0; i <criticalPoints.size(); i ++ ) {
            System.out.printf("%d ", criticalPoints.get(i)[1]);
        }

        int minDistance = Integer.MAX_VALUE;
        // int minIndex = Integer.MAX_VALUE;
        // int maxIndex = -1;

        for(int i = 1; i < criticalPoints.size(); i ++) {
            int[] curCriticalPoint = criticalPoints.get(i);
            // minIndex = Math.min(minIndex , curCriticalPoint[1]);
            // maxIndex = Math.max(maxIndex , curCriticalPoint[1]);

            int prevIndex = criticalPoints.get(i - 1)[1];
            minDistance = Math.min(minDistance , curCriticalPoint[1] - prevIndex);
        }

        if(criticalPoints.size() < 2) {
            int[] ans = {-1 , -1};
            return ans;
        }
        int maxDistance = criticalPoints.get(criticalPoints.size() - 1)[1] - criticalPoints.get(0)[1];

        int[] ans = {minDistance , maxDistance};
        return ans;

    }
}