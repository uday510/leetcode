class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        int longest = 0, leftIdx = 0, rightIdx = 0,
        len = s.length();

        while (rightIdx < len) {
            frequencyMap.merge(s.charAt(rightIdx), 1, Integer::sum);

            while (leftIdx < rightIdx && frequencyMap.get(s.charAt(rightIdx)) > 1) {
                frequencyMap.merge(s.charAt(leftIdx), -1, Integer::sum);
                ++leftIdx;
            }

            longest = Math.max(longest, rightIdx - leftIdx + 1);
            ++rightIdx;
        }

        return longest;
    }
}