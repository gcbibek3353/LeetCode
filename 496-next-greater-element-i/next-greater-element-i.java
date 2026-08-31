class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer , Integer> nums2Map = new HashMap<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < nums2.length; i ++) {
            int curElm = nums2[i];
            while(!stack.isEmpty() && stack.peek() < curElm){
                nums2Map.put(stack.pop(), curElm);
            }
            stack.push(curElm);
        }
        while(!stack.isEmpty()) {
            nums2Map.put(stack.pop(), - 1);
        }

        int[] ans = new int[nums1.length];
        for(int i = 0; i < nums1.length; i ++) {
            ans[i] = nums2Map.get(nums1[i]);
        }
        return ans;
    }
}