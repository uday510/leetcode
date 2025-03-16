class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Set<Character> open = new HashSet<>();
        Map<Character, Character> mappings = new HashMap<>();
        open.add('(');
        open.add('[');
        open.add('{');
        mappings.put(')', '(');
        mappings.put(']', '[');
        mappings.put('}', '{');

        for (char ch : s.toCharArray()) {
            if (open.contains(ch)) {
                stack.push(ch);
            } else {
                if (stack.isEmpty() || stack.peek() != mappings.get(ch)) 
                    return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}