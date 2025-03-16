class Solution {
    Map<Character, Character> mappings;
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        mappings = new HashMap<>();
        mappings.put(')', '(');
        mappings.put(']', '[');
        mappings.put('}', '{');

        for (char ch : s.toCharArray()) {
            if (isOpen(ch)) {
                stack.push(ch);
            } else {
                if (stack.isEmpty() || stack.peek() != mappings.get(ch)) 
                    return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    private boolean isOpen(char ch) {
        return !mappings.containsKey(ch);
    }
}