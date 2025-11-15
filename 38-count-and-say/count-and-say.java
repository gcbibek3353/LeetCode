class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        return encode(countAndSay(n - 1));
    }

    private String encode(String s) {
        StringBuilder sb = new StringBuilder();
        char cur = s.charAt(0);
        int count = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == cur) {
                count++;
            } else {
                sb.append(count).append(cur);
                cur = s.charAt(i);
                count = 1;
            }
        }

        // Append the final group
        sb.append(count).append(cur);

        return sb.toString();
    }
}
