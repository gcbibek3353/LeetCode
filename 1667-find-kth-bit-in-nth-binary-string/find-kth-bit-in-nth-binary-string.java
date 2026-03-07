class Solution {
    public char findKthBit(int n, int k) {
        String binaryStr = findString(n);
        return binaryStr.charAt(k - 1);
    }
    private String findString(int n){
        if(n == 0) return "0";
        String prevString = findString(n - 1);
        return prevString + "1" + reverse(invert(prevString));
    }
    private String reverse(String str){
        StringBuilder newString = new StringBuilder();
        for(int i = str.length() - 1; i >= 0; i --){
            newString.append(str.charAt(i));
        }
        return newString.toString();
    }
    private String invert(String str){
        StringBuilder newString = new StringBuilder();
        for(int i = 0; i < str.length(); i ++){
            if(str.charAt(i) == '0') newString.append('1');
            else newString.append('0');
        }
        return newString.toString();
    }
}