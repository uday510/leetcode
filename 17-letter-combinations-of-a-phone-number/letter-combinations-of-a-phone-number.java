class Solution {

    private static final char[][] MAP = {
        {}, {}, 
        {'a','b','c'}, 
        {'d','e','f'}, 
        {'g','h','i'}, 
        {'j','k','l'}, 
        {'m','n','o'}, 
        {'p','q','r','s'}, 
        {'t','u','v'}, 
        {'w','x','y','z'}
    };

    public List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;

        char[] path = new char[digits.length()];
        dfs(digits, 0, path, res);

        return res;
    }

    private void dfs(String digits, int index, char[] path, List<String> res) {

        if (index == digits.length()) {
            res.add(new String(path));
            return;
        }

        char[] letters = MAP[digits.charAt(index) - '0'];

        for (char c : letters) {
            path[index] = c;
            dfs(digits, index + 1, path, res);
        }
    }
}