class Solution {
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>();
        for(String curToken : tokens) {
            if(
                curToken.equals("+") ||
                curToken.equals("-") ||
                curToken.equals("*") ||
                curToken.equals("/") 
                ){
                    int secondOperand = Integer.parseInt(stack.poll());
                    int firstOperand = Integer.parseInt(stack.poll());
                    int ans = evaluate(firstOperand , secondOperand , curToken);
                    stack.push(ans + "");
                }
                else stack.push(curToken);
        }
        return Integer.parseInt(stack.poll());
    }

    private int evaluate(int a , int b , String operator){
        switch(operator){
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
            default: throw new IllegalArgumentException();
        }
    }
}