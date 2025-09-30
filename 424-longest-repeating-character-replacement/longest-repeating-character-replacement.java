class Solution {
    public int characterReplacement(String s, int k) {
        int i = 0, maxFreq = 0, longest = 0, n = s.length();
        int[] freq = new int[128];

        for (int j = 0; j < n; j++) {
            freq[s.charAt(j)]++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(j)]);

            while ((j - i + 1) - maxFreq > k) {
                freq[s.charAt(i++)]--;
            }

            if ((j - i + 1) - maxFreq <= k) {
                longest = Math.max(longest, j - i + 1);
            }
        }


        return longest;
    }
}

/**

longest = 4

i = 2
j = 5
A: 0 + 1 + 1 + 1 + 1

B: 3


maxFreq: 2

 */