class Solution {
    List<List<String>> ans = new ArrayList<>();
    List<String> curList = new ArrayList<>();

    public List<List<String>> partition(String s) {
        helper(0, s);
        return ans;
    }

   private void helper(int curIndex, String s){
    if(curIndex == s.length()){
        ans.add(new ArrayList(curList));
        return;
    }

    for(int i = curIndex ; i < s.length(); i ++){
        if(isPalindrome(s , curIndex , i)){
            curList.add(s.substring(curIndex , i + 1));
            helper(i + 1 , s);
            curList.remove(curList.size() - 1);
        } 
    }

   }

    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}