class Solution {
    Map<Character, Character> map = new HashMap<>();
    {
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
    }
    public boolean isValid(String s) {
        var st = new Stack<Character>();

        for (char c : s.toCharArray()) {
            if (open(c))
                st.push(c);
            else {
                if (st.isEmpty() || st.peek() != map.get(c)) 
                    return false;
                st.pop();
            }
        }
        return st.isEmpty();
    }
    boolean open(char c) {
        return map.containsValue(c);
    }
}