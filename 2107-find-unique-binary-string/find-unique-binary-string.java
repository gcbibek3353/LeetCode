class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Set<String> st = new HashSet<>();
        int n = nums.length;
        for(int i = 0; i < nums.length; i ++) {
            st.add(nums[i]);
        }
        return generate("",st,n);
    }

    protected String generate(String s , Set<String> st , int n) {
        if(s.length() == n) return (st.contains(s) ? "" : s);
        String zeroAddedAns = generate(s + '0', st , n);
        if(zeroAddedAns.length() >= 1) return zeroAddedAns;
        return generate(s + '1', st , n);
    }
}