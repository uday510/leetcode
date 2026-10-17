class Solution {

    private final static Map<Character, char[]> map = new HashMap<>();
    static {
        map.put('2', new char[] {'a', 'b', 'c'});
        map.put('3', new char[] {'d', 'e', 'f'});
        map.put('4', new char[] {'g', 'h', 'i'});
        map.put('5', new char[] {'j', 'k', 'l'});
        map.put('6', new char[] {'m', 'n', 'o'});
        map.put('7', new char[] {'p', 'q', 'r', 's'});
        map.put('8', new char[] {'t', 'u', 'v'});
        map.put('9', new char[] {'w', 'x', 'y', 'z'});
    };

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) 
            return res;
        
        dfs(digits, 0, new StringBuilder(), res);
        return res;
    }

    private void dfs(String s, int idx, StringBuilder sb, List<String> res) {
        if (idx == s.length()) {
            res.add(sb.toString());
            return;
        }

        for (char c : map.get(s.charAt(idx))) {
            sb.append(c);
            dfs(s, idx + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}