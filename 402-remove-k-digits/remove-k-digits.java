class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            char digit = num.charAt(i);
            while (!st.isEmpty() && k > 0 && st.peek() > digit) {
                st.pop();
                k--;
            }
            st.push(digit);
        }

        while (k > 0) {
            st.pop(); // Pop the last added digits
            k--; // Decrement k by 1
        }

        if (st.isEmpty())
            return "0";

        StringBuilder res = new StringBuilder();

        // Add digits from stack to result
        while (!st.isEmpty()) {
            res.append(st.pop());
        }
        while (res.length() > 0 && res.charAt(res.length() - 1) == '0') {
            res.deleteCharAt(res.length() - 1);
        }

        // Reverse the string to get the correct number
        res.reverse();

        // If result is empty, return "0"
        if (res.length() == 0)
            return "0";

        // Return the result as a string
        return res.toString();

    }
}