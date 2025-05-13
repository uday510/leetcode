class Solution {
    public int maxFreqSum(String s) {
        int[] cnt = new int[127];
        Set<Character> vowels= new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        int vowel = 0, consonent = 0;
        for (char ch : s.toCharArray()) {
            cnt[ch]++;
            if (vowels.contains(ch)) vowel = Math.max(vowel, cnt[ch]);
            else consonent = Math.max(consonent, cnt[ch]);
        }

        return vowel + consonent;
    }
}