class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> mapping = new HashMap<>();
        
        mapping.put(']', '[');
        mapping.put(')', '(');
        mapping.put('}', '{');

        for (char ch : s.toCharArray()) {
            if (!mapping.containsKey(ch)) {
                stack.push(ch);
            } else {
                if (stack.isEmpty() || mapping.get(ch) != stack.peek()) return false;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}