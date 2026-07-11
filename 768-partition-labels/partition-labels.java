class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character , Integer> mp = new HashMap<>();
        for(int i = 0; i < s.length(); i ++) {
            mp.put(s.charAt(i), i);
        }
        List<Integer> ans = new ArrayList<>();
        int curPartMaxIndex = 0;
        int lastAns = 0;
        for(int i = 0; i < s.length(); i ++) {
            int curCharIndex = mp.get(s.charAt(i));
            curPartMaxIndex = Math.max(curPartMaxIndex , curCharIndex);
            if(curPartMaxIndex == i){
                System.out.printf("i : %d , curCharIndex : %d , ansTop : %d \n", i , curCharIndex , ans.size() == 0 ? 0 : ans.get(ans.size() - 1));
                if(ans.size() == 0){
                    lastAns = i + 1;
                    ans.add(i + 1);
                } 
                else{
                    int curSize = i - lastAns + 1;
                    lastAns = lastAns + curSize;
                    ans.add(curSize);
                }
            }
        }
        return ans;
    }
}