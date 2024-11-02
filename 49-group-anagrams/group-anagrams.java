class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        var map = new HashMap<String, List<String>>();

        for (String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String s = new String(ch);

            if (!map.containsKey(s))
                map.put(s, new ArrayList<>());
            
            map.get(s).add(str);
        }
        return new ArrayList(map.values());
    }
}