class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Testing LeetSync with github repo

      Map<Integer,Integer> map1 = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i < n; i ++){
            map1.put(nums[i],i);
        }
        for(int i = 0; i < n; i ++){
            int complement = target - nums[i];
            if(map1.containsKey(complement) && i != map1.get(complement)){
                return new int[]{i,map1.get(complement)};
            }
            
         }
         return new int[]{};

    }
}