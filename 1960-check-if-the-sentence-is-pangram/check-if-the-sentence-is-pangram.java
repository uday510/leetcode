class Solution {
    public boolean checkIfPangram(String S) {
        int[] cnt = new int[26];

        for (int i = 0; i < S.length(); i++) {
            cnt[S.charAt(i) - 'a']++;
        }

        for (int i : cnt) 
            if (i == 0)
                return false;

        return true;
    }
}