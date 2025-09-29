class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] chrs = s.toCharArray();
            Arrays.sort(chrs);

            String k = new String(chrs);

            map.computeIfAbsent(k, _ -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }
}