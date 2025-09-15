class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] freq = new int[128];
        int i = 0, j = 0;
        int longest = 0, maxFreq = 0;

        while (j < n) {
            freq[s.charAt(j)]++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(j)]);

            while ((j - i + 1) - maxFreq > k) {
                freq[s.charAt(i)]--;
                maxFreq = 0;
                for (int f : freq) maxFreq = Math.max(f, maxFreq);
                i++;
            }   

            if ( j - i + 1 - maxFreq <= k) {
                longest = Math.max(longest, j - i + 1);
            }
            
            j++;
        }

        return longest;
    }
}