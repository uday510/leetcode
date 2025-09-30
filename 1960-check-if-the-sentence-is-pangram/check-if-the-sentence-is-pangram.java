class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] cnt = new int[26];
        
        for (int i = 0; i < sentence.length(); i++) {
            cnt[sentence.charAt(i) - 'a']++;
        }

        for (int i : cnt) {
            if (i == 0) return false;
        }

        return true;
    }
}