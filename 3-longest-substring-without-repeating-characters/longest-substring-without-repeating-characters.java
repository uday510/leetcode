class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int[] freq = new int[128];
        int leftIdx = 0, rightIdx = 0, longest = 0, n = s.length();

        while (rightIdx < n) {
            freq[s.charAt(rightIdx)]++;

            while (freq[s.charAt(rightIdx)] > 1) {
                freq[s.charAt(leftIdx)]--;
                leftIdx++;
            }

            longest = Math.max(longest, rightIdx - leftIdx + 1);
            rightIdx++;
        }

        return longest;
    }
}