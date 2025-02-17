import java.util.*;

class Solution {
    
    private static final Map<Character, List<Character>> DIGIT_TO_LETTERS = initializeMapping();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        backtrack(0, digits, new StringBuilder(), result);
        return result;
    }

    private void backtrack(int index, String digits, StringBuilder sb, List<String> result) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }

        char digit = digits.charAt(index);
        List<Character> letters = DIGIT_TO_LETTERS.get(digit);

        if (letters == null) return; 

        for (char letter : letters) {
            sb.append(letter);
            backtrack(index + 1, digits, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private static Map<Character, List<Character>> initializeMapping() {
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
