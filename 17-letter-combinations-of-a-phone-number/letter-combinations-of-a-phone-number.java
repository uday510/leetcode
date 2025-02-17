class Solution {
    private static final Map<Character, List<Character>> DIGIT_LETTERS = initialize();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        dfs(0, new StringBuilder(), result, digits);
        return result;
    }

    private void dfs(int index, StringBuilder sb, List<String> result, String digits) {
        if (sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }

        List<Character> letters = DIGIT_LETTERS.get(digits.charAt(index));
        if (letters == null) return;

        for (char ch : letters) {
            sb.append(ch);
            dfs(index + 1, sb, result, digits);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private static Map<Character, List<Character>> initialize() {
        Map<Character, List<Character>> map = new HashMap<>();
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));
        return map;
    }
}