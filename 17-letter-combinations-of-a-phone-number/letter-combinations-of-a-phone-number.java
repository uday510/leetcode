class Solution {

    static Map<Character, char[]> map = new HashMap<>();
    static {
        map.put('2', new char[] {'a', 'b', 'c'});
        map.put('3', new char[] {'d', 'e', 'f'});
        map.put('4', new char[] {'g', 'h', 'i'});
        map.put('5', new char[] {'j', 'k', 'l'});
        map.put('6', new char[] {'m', 'n', 'o'});
        map.put('7', new char[] {'p', 'q', 'r', 's'});
        map.put('8', new char[] {'t', 'u', 'v'});
        map.put('9', new char[] {'w', 'x', 'y', 'z'});
    }
    List<String> res;
    String digits;
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        this.digits = digits;

        dfs(0, new StringBuilder());
        return res;
    }

    private void dfs(int i, StringBuilder sb) {
        if (i >= digits.length()) {
            if (sb.length() > 0) res.add(sb.toString());
            return;
        }

        for (char ch : map.get(digits.charAt(i))) {
            sb.append(ch);
            dfs(i + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}