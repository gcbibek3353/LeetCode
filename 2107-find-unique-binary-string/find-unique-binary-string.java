class Solution {
    int n;
    Set<String> st;
    public String findDifferentBinaryString(String[] nums) {
        n = nums.length;
        st = new HashSet<>();
        for(String num : nums) st.add(num);
        return generate("");
    }

    protected String generate(String num){
        if(num.length() == n){
            if(!st.contains(num)) return num;
            else return "";
        }
        String zeroAddedAns = generate("0" + num);
        if(zeroAddedAns != "") return zeroAddedAns;
        String oneAddedAns = generate("1" + num);
        return oneAddedAns;
    }
}