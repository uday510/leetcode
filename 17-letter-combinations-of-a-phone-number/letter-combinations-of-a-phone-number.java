class Solution {
    List<String> list;
    Map<Character, char[]> map;
    public List<String> letterCombinations(String digits) {
       intialize(digits);
       dfs(0, digits, new StringBuilder());
       return list;
    }
    private void dfs(int idx, String digits, StringBuilder sb) {
        if (idx >= digits.length()) {
            if (sb.length() > 0 ) 
                list.add(sb.toString());
            return;
        }   

        for (char ch : map.get(digits.charAt(idx))) {
            sb.append(ch);
            dfs(idx + 1, digits, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
    private void intialize(String digits) {
        list = new ArrayList<>();
        map = new HashMap<>();

        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
    }
}

