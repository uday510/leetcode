class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        

        Map<String, List<String>> grps = new HashMap<>();

        int[] cnts = new int[26];


        for (String s : strs) {

            for (int i = 0; i < s.length(); i++) {
                cnts[s.charAt(i) - 'a']++;
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 26; i++) {
                sb.append(cnts[i]).append('#');
                cnts[i] = 0;
            }

            String key = new String(sb);

            grps.computeIfAbsent(key, _ -> new ArrayList<>()).add(s);

        }

        return new ArrayList<>(grps.values());
    }
}