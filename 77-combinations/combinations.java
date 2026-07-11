class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> curList = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        generate(0, n , k);
        return ans;
    }

    private void generate(int noOfDigits , int n , int k){
        if(noOfDigits == k){
            ans.add(new ArrayList(curList));
            return;
        }
        int lastDigitInCurList = 0;
        lastDigitInCurList = curList.size() > 0 ? curList.get(curList.size() - 1) : 0;
        for(int i = lastDigitInCurList + 1; i <= n; i ++) {
            curList.add(i);
            generate(noOfDigits + 1 , n , k);
            curList.remove(curList.size() - 1);
        }
    }
}