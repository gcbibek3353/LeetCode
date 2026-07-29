class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int l = 0;
        int r = n / 2;
        if(n < 4) return s;
        String leftSideString = s.substring(l , r);
        String sortedLeftSide = sortString(leftSideString);
        String rightSideString = reverseString(sortedLeftSide);
        System.out.printf("l : %s , sl : %s r : %s , ", leftSideString,sortedLeftSide,rightSideString  );
        if(n % 2 == 1){
            Character midChar = s.charAt(n / 2);
            sortedLeftSide = sortedLeftSide + midChar;
        }
        sortedLeftSide = sortedLeftSide + rightSideString;
        return sortedLeftSide;
    }

    private String sortString(String s) {
        char[] charArr = s.toCharArray();
        Arrays.sort(charArr);
        // return String.join("", charArr);
        return new String(charArr);
    }

    private String reverseString(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}