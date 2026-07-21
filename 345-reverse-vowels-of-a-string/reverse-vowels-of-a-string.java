class Solution {
    public String reverseVowels(String s) {
        int l = 0;
        int r = s.length() - 1;
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        char[] chars = s.toCharArray();
        while(l <= r){
            while(l < r && !vowels.contains(s.charAt(l))) l ++;
            while(l < r && !vowels.contains(s.charAt(r))) r --;
            System.out.printf("l : %d , r : %d \n", l , r);
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            l ++;
            r --;
        }
        return new String(chars);
    }
}