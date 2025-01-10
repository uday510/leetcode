class Solution {

    Trie trie;
    int result;
    String prefix;

    public int prefixCount(String[] words, String pref) {
        intialize(words, pref);

        return result;
    }

    private void intialize(String[] words, String pref) {
        trie = new Trie();
        prefix = pref;

        for (String word : words) {
            insertIntoTrie(word);
        }
    }

    private void insertIntoTrie(String word) {
        Trie curr = trie;
        int len = Math.min(word.length(), prefix.length());

        for (int idx = 0; idx < len; ++idx) {
            if (word.charAt(idx) != prefix.charAt(idx)) {
                return;
            }

            int index = word.charAt(idx) - 'a';
            if (curr.nodes[index] == null) {
                curr.nodes[index] = new Trie();
            }

            if (idx == prefix.length() - 1) {
                result += 1;
            }
        }

        
    }

    private class Trie {
        Trie[] nodes;
        int count;

        Trie() {
            this.nodes = new Trie[26];
            count = 0;
        }
    }
}