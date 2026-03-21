class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);

        for(int num : nums) pq.add(num);

        int ans = -1;
        for(int i = 1; i <= k; i ++){
            ans = pq.poll();
        }
        return ans;
    }
}