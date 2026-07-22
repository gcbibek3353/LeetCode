class Solution {
    public String reverseWords(String s) {
        String[] strs = s.trim().split("\\s+");
        List<String> list = Arrays.asList(strs);
        for(int i = 0; i < list.size(); i ++) if(list.get(i) == "") list.remove(i);
        Collections.reverse(list); 
        String ans =  String.join(" ", list); 
        return ans;
    }
}