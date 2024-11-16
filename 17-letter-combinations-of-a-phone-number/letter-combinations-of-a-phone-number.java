class Solution {
    Map<Character, String[]>map;
    List<String> res;
    public List<String> letterCombinations(String digits) {
        intialize();

        if (digits.length() == 0) {
            return res;
        }

        dfs(digits, 0, new StringBuilder());

        return res;
    }
    private void dfs(String digits, int index, StringBuilder sb) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }

            char c = digits.charAt(index);

            for (String s : map.get(c)) {
                sb.append(s);
                dfs(digits, index + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
            }

    }
    private void intialize() {
        map = new HashMap<>();
        res = new ArrayList<>();

        map.put('2', new String[]{"a", "b", "c"});
        map.put('3', new String[]{"d", "e", "f"});
        map.put('4', new String[]{"g", "h", "i"});
        map.put('5', new String[]{"j", "k", "l"});
        map.put('6', new String[]{"m", "n", "o"});
        map.put('7', new String[]{"p", "q", "r", "s"});
        map.put('8', new String[]{"t", "u", "v"});
        map.put('9', new String[]{"w", "x", "y", "z"});

    }
}