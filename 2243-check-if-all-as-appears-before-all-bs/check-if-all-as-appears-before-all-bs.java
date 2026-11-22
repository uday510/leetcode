class Solution {
    public boolean checkString(String s) {
        int cnt = 0;
        char[] chars = s.toCharArray();

        for (char c : chars) {
            cnt += c == 'a' ? 1 : 0;
        }

        for (char c : chars) {
            cnt -= c == 'a' ? 1 : 0;

            if (c == 'b' && cnt != 0) 
                return false;
        }

        return cnt == 0;
    }
}