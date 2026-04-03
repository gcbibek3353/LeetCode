class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> mp = new HashMap<>();
        for(int num : nums) mp.put(num , mp.getOrDefault(num , 0) + 1);
        Queue<Integer> minHeap = new PriorityQueue((a,b) -> mp.get(a) - mp.get(b));
        for(int key : mp.keySet()){
            minHeap.offer(key);
            if(minHeap.size() > k) minHeap.poll();
        }

        int[] ans = new int[k];
        for(int i = 0; i < k; i ++){
            ans[i] = minHeap.poll();
        }
        return ans;
    }
}