class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> st1 = new HashSet<>();
        Set<Integer> st2 = new HashSet<>();
        for(int num : nums1) st1.add(num);
        for(int num : nums2) st2.add(num);
        List<Integer> ans1 = new ArrayList<>();
        List<Integer> ans2 = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for(int i = 0; i < nums1.length; i ++ ){
            int num = nums1[i];
            if(!st2.contains(num)){
                if(i == 0) ans1.add(num);
                else {
                if( nums1[i] != nums1[i - 1])ans1.add(num);
                }
            } 
        }

        for(int i = 0; i < nums2.length; i ++){
            int num = nums2[i];
            if(!st1.contains(num)){
                if(i == 0) ans2.add(num);
                else{
                    if( nums2[i] != nums2[i - 1])ans2.add(num);
                }
            } 
        }
        List<List<Integer>> ans =  new ArrayList<>();
        ans.add(ans1);
        ans.add(ans2);
        return ans;
    }
}