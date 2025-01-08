class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        int[] count;

        for (String str : strs) {
            count = new int[26];

            for (int ch : str.toCharArray()) {
                count[ch - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i : count) {
                sb.append(i);
                sb.append("#");
            }

            String key = sb.toString();

            map.computeIfAbsent(key, x -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}