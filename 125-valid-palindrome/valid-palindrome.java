class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder filtered = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                filtered.append(Character.toLowerCase(c));
            }
        }

        String originalFiltered = filtered.toString();
        String reversedFiltered = filtered.reverse().toString();

        return originalFiltered.equals(reversedFiltered);
    }
}