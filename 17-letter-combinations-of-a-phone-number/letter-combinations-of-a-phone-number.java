class Solution {
    List<String> ans = new ArrayList<>();
    static Map<Character, String> mp = new HashMap<>();
    static {
        mp.put('2', "abc");
        mp.put('3', "def");
        mp.put('4', "ghi");
        mp.put('5', "jkl");
        mp.put('6', "mno");
        mp.put('7', "pqrs");
        mp.put('8', "tuv");
        mp.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {

        helper(0, digits, "");
        return ans;
    }

    private void helper(int curIndex, String digits, String curString) {
        if (curIndex == digits.length()){
            ans.add(curString);
            return;
        }
        String possibleChars = mp.get(digits.charAt(curIndex));
        for (int i = 0; i < possibleChars.length(); i++) {
            helper(curIndex + 1, digits, curString + possibleChars.charAt(i));
        }
    }
}