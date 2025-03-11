import java.util.HashMap;

class Solution {
    public int numberOfSubstrings(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        int startIdx = 0, endIdx = 0, count = 0, len = s.length();

        while (endIdx < len) {
            frequencyMap.merge(s.charAt(endIdx), 1, Integer::sum);
            while (frequencyMap.size() == 3) {
                char ch = s.charAt(startIdx);
                frequencyMap.put(ch, frequencyMap.get(ch) - 1);

                if (frequencyMap.get(ch) == 0) {
                    frequencyMap.remove(ch);
                }

                count += (len - endIdx);
                ++startIdx;
            }
            ++endIdx;
        }
        return count;
    }
}