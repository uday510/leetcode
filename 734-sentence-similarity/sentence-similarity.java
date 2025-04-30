class Solution {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {

        int m = sentence1.length, n = sentence2.length;
        if (m != n) return false;
        
      Set<String> seen = new HashSet<>();

      for (var pair : similarPairs) {
        seen.add(pair.get(0) + ":" + pair.get(1));
        seen.add(pair.get(1) + ":" + pair.get(0));
      }

      if (seen.isEmpty()) return true;

      for (int i = 0; i < m; ++i) {
        String str = sentence1[i] + ":" + sentence2[i];

        if (sentence1[i].equals(sentence2[i])) continue;
        if (!seen.contains(str)) return false;
        // seen.remove(str);
      }

      return true;

    }
}