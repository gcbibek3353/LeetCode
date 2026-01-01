class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for(int i = digits.length - 1; i >= 0; i --) {
            int curDigit = digits[i] + carry;
            if(curDigit > 9){
                digits[i] = 0;
                carry = 1;
            } 
            else{
            digits[i] = curDigit;
            return digits;
            } 
        }
        int[] ans = new int[digits.length + 1];
        ans[0] = 1;
        for(int i = 0; i < digits.length; i ++) {
            ans[i + 1] = digits[i];
        }
        return ans;
    }
}