class Solution {
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {

            if (token.equals("+") ||
                token.equals("-") ||
                token.equals("*") ||
                token.equals("/")) {

                int b = stack.pop();
                int a = stack.pop();

                int result = evaluate(a, b, token);
                stack.push(result);

            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    private int evaluate(int a, int b, String operator) {
        switch (operator) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
            default: throw new IllegalArgumentException();
        }
    }
}
