class Solution {
    Trie trie;
    int result;
    public int prefixCount(String[] words, String pref) {
        intialize(words, pref);

        return result;
    }

    private void intialize(String[] words, String pref) {
        trie = new Trie();
        for (String word : words) {
            insertIntoTrie(word, pref);
        }
    }

    private void insertIntoTrie(String word, String pref) {
        Trie curr = trie;

        for (int idx = 0; idx < Math.min(pref.length(), word.length()); ++idx) {
            if (word.charAt(idx) != pref.charAt(idx)) {
                return;
            }

            int index = word.charAt(idx) - 'a';
            if (curr.nodes[index] == null) {
                curr.nodes[index] = new Trie();
            }

            curr = curr.nodes[index];
            if (idx == pref.length() - 1) {
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