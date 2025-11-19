class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) return false;

        Map<Character, String> mapChar = new HashMap<>();
        Map<String, Character> mapWord = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            char ch = pattern.charAt(i);

            if (mapChar.containsKey(ch)) {
                if (!mapChar.get(ch).equals(w)) return false;
            } else {
                if (mapWord.containsKey(w)) return false;

                mapWord.put(w, ch);
                mapChar.put(ch, w);
            }
        }

        return true;
    }
}