class Solution {
    Map<Character, String[]> DIGIT_LETTERS = new HashMap<>();
    List<String> res = new ArrayList<>();
    {
        DIGIT_LETTERS.put('0', new String[] {"0"});
        DIGIT_LETTERS.put('1', new String[] {"1"});
        DIGIT_LETTERS.put('2', new String[] {"a", "b", "c"});
        DIGIT_LETTERS.put('3', new String[] {"d", "e", "f"});
        DIGIT_LETTERS.put('4', new String[] {"g", "h", "i"});
        DIGIT_LETTERS.put('5', new String[] {"j", "k", "l"});
        DIGIT_LETTERS.put('6', new String[] {"m", "n", "o"});
        DIGIT_LETTERS.put('7', new String[] {"p", "q", "r", "s"});
        DIGIT_LETTERS.put('8', new String[] {"t", "u", "v"});
        DIGIT_LETTERS.put('9', new String[] {"w", "x", "y", "z"});
    }
    public List<String> letterCombinations(String digits) {        
        dfs(0, digits, new StringBuilder());
        return res;
    }
    public void dfs(int i, String digits, StringBuilder sb) {
        if (i == digits.length()) {
            if (sb.length() > 0) {
                res.add(sb.toString());
            }
            return;
        }

        char digit = digits.charAt(i);

        String[] digitLetters = DIGIT_LETTERS.get(digit);

        for (String letter : digitLetters) {
            sb.append(letter);
            dfs(i+1, digits, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}