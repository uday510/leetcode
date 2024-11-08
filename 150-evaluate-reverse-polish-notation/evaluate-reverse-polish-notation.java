class Solution {
    private final Map<String, Operation> OPERATIONS = new HashMap<>();

    public Solution() {
        OPERATIONS.put("+", (num1, num2) -> num1 + num2);
        OPERATIONS.put("-", (num1, num2) -> num1 - num2);
        OPERATIONS.put("*", (num1, num2) -> num1 * num2);
        OPERATIONS.put("/", (num1, num2) -> num1 / num2);
    }
    public int evalRPN(String[] tokens) {
        var stack = new Stack<Integer>();

        for (String token : tokens) {
            if (OPERATIONS.containsKey(token)) {
                handleOperation(OPERATIONS.get(token), stack);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
    private void handleOperation(Operation operation, Stack<Integer> stack) {
        try {
            int right = stack.pop();
            int left = stack.pop();

            int result = operation.eval(left, right);
            stack.push(result);
        } catch(Exception e) {

        }
    }
    @FunctionalInterface
    private interface Operation {
        int eval(int num1, int num2);
    }
}