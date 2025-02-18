class Solution {
    public String smallestNumber(String pattern) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        int idx;

        for (idx = 0; idx < pattern.length(); ++idx) {
            stack.push(idx + 1);

            if (pattern.charAt(idx) == 'D') {
                continue;
            }

            removeAndAddToResult(stack, result);
        }

        stack.push(idx + 1);

        removeAndAddToResult(stack, result);

        return result.toString();
    }

    private void removeAndAddToResult(Stack<Integer> stack, StringBuilder sb) {
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
    }
}