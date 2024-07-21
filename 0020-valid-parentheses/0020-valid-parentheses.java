class Solution {
    Map<Character, Character> map;
    public boolean isValid(String s) {
        map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            boolean open = !map.containsKey(c);
            if (open) {
               stack.push(c);
            } else {
               char top = stack.isEmpty() ? '#' : stack.pop();
               if (map.get(c) != top)
                   return false;
            }
        }
        return stack.isEmpty();
    }
}