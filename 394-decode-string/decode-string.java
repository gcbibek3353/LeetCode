class Solution {
    public String decodeString(String s) {
        ArrayDeque<Character> st = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i ++) {
            char curChar = s.charAt(i);
            if(curChar != ']') st.push(curChar);
            else{
                System.out.println(st);
                String curString = "";
                while(st.peek() != '[') curString = st.pop() + curString;
                st.pop();
                int curNum = 0;
                int multiplicationFactor = 1;
                while(!st.isEmpty() && Character.isDigit(st.peek())){
                    int digit = st.pop() - '0';
                    curNum += digit * multiplicationFactor;
                    multiplicationFactor *= 10;
                }
                System.out.printf("curNum : %d , curStr : %s \n", curNum, curString);
                for(int count = 0; count < curNum; count ++) {
                    for(int j = 0; j < curString.length(); j ++) {
                        st.push(curString.charAt(j));
                    }
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()){
            ans.insert(0, st.pop());
        }
        return ans.toString();
    }
}