class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < s.length(); i ++) {
            if(s.charAt(i) == ' '){
                count = 0;
                continue;
            }
            else{
                count ++;
                arr.add(count);
            }
        }
        return arr.get(arr.size() - 1);
    }
}