class Solution {
    Trie trie;
    public int prefixCount(String[] words, String pref) {
        trie = new Trie();
        intialize(words, pref);

        int result = findPrefixCount(pref);
        return result;
    }
    private int findPrefixCount(String prefix) {
        int count = 0;
        Trie curr = trie;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (curr.nodes[index] == null) {
                return 0;
            }

            curr = curr.nodes[index];
        }
        return curr.count;
    }

    private void intialize(String[] words, String pref) {
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
            curr.count++;
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