class Solution {
    public long wonderfulSubstrings(String word) {
        long totalWonderfulSubstrings = 0;
        int mask = 0;
        long[] count = new long[1024];
        count[0] = 1; 

        for (char ch : word.toCharArray()) {
            mask ^= 1 << (ch - 'a'); 

            totalWonderfulSubstrings += count[mask];

            for (int i = 0; i < 10; i++) {
                totalWonderfulSubstrings += count[mask ^ (1 << i)];
            }

            count[mask]++;
        }

        return totalWonderfulSubstrings;
    }
}