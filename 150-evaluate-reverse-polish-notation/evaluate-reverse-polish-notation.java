import java.util.Stack;
import java.util.HashMap;
import java.util.Map;

class Solution {
    private final Map<String, Operation> operators = new HashMap<>();

    public Solution() {
        operators.put("+", (a, b) -> a + b);
        operators.put("-", (a, b) -> a - b);
        operators.put("*", (a, b) -> a * b);
        operators.put("/", (a, b) -> a / b);
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (operators.containsKey(token)) {
                handleOperation(stack, token);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private void handleOperation(Stack<Integer> stack, String operator) {
        try {
            int right = stack.pop();
            int left = stack.pop();
            int result = operators.get(operator).apply(left, right);
            stack.push(result);
        } catch (Exception e) {
        } 
    }

    @FunctionalInterface
    private interface Operation {
        int apply(int a, int b);
    }
}