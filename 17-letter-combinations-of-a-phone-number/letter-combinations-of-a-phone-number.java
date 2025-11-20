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
    }

    List<String> combs;
    String s;
    int n;

    public List<String> letterCombinations(String digits) {
        combs = new ArrayList<>();
        s = digits;
        n = s.length();

        dfs(0, new StringBuilder());
        return combs;
    }
    private void dfs(int i, StringBuilder sb) {
        if (i >= n) {
            combs.add(sb.toString());
            return;
        }

        for (char ch : map.get(s.charAt(i))) {
            sb.append(ch);
            dfs(i + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}