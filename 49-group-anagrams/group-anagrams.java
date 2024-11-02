class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       var map = new HashMap<String, List<String>>();

       for (String s : strs) {
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        String str = new String(ch);

        if (!map.containsKey(str))
            map.put(str, new ArrayList<>());

        map.get(str).add(s);
       }
       return new ArrayList<>(map.values());
    }
}