class Solution {
    public int numberOfSubstrings(String s) {
        var map = new HashMap<Character, Integer>();
        int count = 0;
        int left = 0;
        int right = 0;
        int len = s.length();

        while (right < len) {
            map.merge(s.charAt(right), 1, Integer::sum);
            while (left < right && map.size() == 3) {
                char ch = s.charAt(left);
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) map.remove(ch);
                left++;
                count += len - right;
            }
            right++;
        }
        
        return count;
    }
}