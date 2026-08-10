class Solution {
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    
    private void insert(int n) {
        while(!queue.isEmpty() && queue.peekLast() < n) {
            queue.pollLast();
        }
        queue.offer(n);
    }

    // private void printQueue() {
    //     ArrayDeque<Integer> temp = new ArrayDeque<>();
    //     while(!queue.isEmpty()){
    //         int curVal = queue.poll();
    //         temp.offer(curVal);
    //         System.out.printf( "%d , ", curVal);
    //     }
    //     queue = temp;
    // }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 1) return nums;
        for(int i = 0; i < k - 1; i ++){
            insert(nums[i]);
        }
        int[] ans = new int[nums.length - k + 1];
        for(int i = 0; i <= nums.length - k; i ++) {
            insert(nums[i + k - 1]);
            ans[i] = queue.peek();
            if(nums[i] == queue.peek()) queue.poll();
            // System.out.printf("i : %d ", i);
            // printQueue();
            // System.out.println();
        }
        return ans;
    }
}