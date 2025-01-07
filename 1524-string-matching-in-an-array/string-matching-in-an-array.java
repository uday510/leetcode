class Solution {
    List<String> result;
    int len;
    public List<String> stringMatching(String[] words) {
        result = new ArrayList<>();
        len = words.length;

        for (int idx = 0; idx < len; ++idx) {
            
            findSubstrings(words, idx);
        }

        return result;
    }
    private void findSubstrings(String[] words, int index) {
        String pattern = words[index];

        for (int idx = 0; idx < len; ++idx) {
            if (idx == index) {
                continue;
            }

            if (words[idx].contains(pattern)) {
                result.add(pattern);
                return;
            }
        }
    }
}