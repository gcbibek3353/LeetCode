class Solution {
    public int removeDuplicates(int[] nums) {
         int k = 2;

    for(int i = 2; i <= nums.length -1 ; i ++) {
        int num = nums[i];
        if(num != nums[k - 2]) nums[k ++] = num;
    }

    return k;
    }
}