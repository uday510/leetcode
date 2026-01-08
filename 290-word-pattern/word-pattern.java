class Solution {
    public boolean wordPattern(String p, String s) {
        
        String[] words = s.split(" ");
        if (words.length != p.length()) return false;

        Map<Character, String> cMap = new HashMap<>();
        Map<String, Character> wMap = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            char ch = p.charAt(i);

            if (cMap.containsKey(ch)) {
                if (!cMap.get(ch).equals(w)) return false;
            } else if (wMap.containsKey(w)) {
                if (wMap.get(w) != ch) return false;
            }

            wMap.put(w, ch);
            cMap.put(ch, w);
        }

        return true;
    }
}