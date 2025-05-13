class Solution {
    public int maxFreqSum(String s) {
        int[] cnt = new int[127];
        Set<Character> vowels= new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        for (char ch : s.toCharArray()) {
            cnt[ch]++;
        }

        int vowel = 0, consonent = 0;
        for (int idx = 97; idx < 127; ++idx) {
            if (vowels.contains((char) idx)) vowel = Math.max(vowel, cnt[idx]);
            else consonent = Math.max(consonent, cnt[idx]);
        }
        return vowel + consonent;
    }
}