class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] firstStringCount = new int[26];
        int[] secondStringCount = new int[26];

        for(int i = 0; i < s1.length(); i ++) {
            char curChar = s1.charAt(i);
            firstStringCount[curChar - 'a'] ++;
        }

        if(s2.length() < s1.length()) return false;
        int l = 0;
        int r = s1.length() - 1;
        for(int i = l; i <= r; i ++) {
            char curChar = s2.charAt(i);
            if(firstStringCount[curChar - 'a'] != 0) secondStringCount[curChar - 'a'] ++;
        }

        while(r < s2.length()) {
            // System.out.printf("l : %d , r : %d \n" , l , r);
            if(compareArrays(firstStringCount,secondStringCount)) return true;
            char leftChar = s2.charAt(l);
            if(firstStringCount[leftChar - 'a'] != 0) secondStringCount[leftChar - 'a'] --;
            l ++;

            if(r != s2.length() - 1){
                char nextRightChar = s2.charAt(r + 1);
                if(firstStringCount[nextRightChar - 'a'] != 0) secondStringCount[nextRightChar - 'a'] ++;
            }
            r ++;
        }
        return false;
    }

    private boolean compareArrays(int[] arr1 , int[] arr2) {
        for(int i = 0; i < arr1.length; i ++) {
            if(arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}