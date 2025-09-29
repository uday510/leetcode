class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            int[] cnt = new int[26];
            for (int i = 0; i < s.length(); i++) cnt[s.charAt(i) - 'a']++;

            StringBuilder sb = new StringBuilder();
            for (int i : cnt) sb.append(i).append("#");

            String k = sb.toString();

            map.computeIfAbsent(k, _ -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }
}