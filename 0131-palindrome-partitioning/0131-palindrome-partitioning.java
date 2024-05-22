class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();

        partition(s, 0, new ArrayList<>(), res);
        return res;
    }

    public void partition(String s, int index, List<String> temp,
                                                List<List<String>> res) {

        if (index == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        
        for (int i = index; i < s.length(); ++i) {
            String substring = s.substring(index, i + 1);
            if (isPalindrome(substring)) {
                temp.add(substring);
                partition(s, i + 1, temp, res);
                temp.remove(temp.size() - 1);
            }
        }
    }
    public boolean isPalindrome(String s) {
        int i = 0; int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}