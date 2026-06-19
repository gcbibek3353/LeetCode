class Solution {
    public String removeStars(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for(Character c : s.toCharArray()) {
            if(c == '*') {
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        StringBuilder str = new StringBuilder();

        while(stack.size() > 0) {
            Character c = stack.pop();
            str.insert(0 , c);
        }

        return str.toString();
    }
}