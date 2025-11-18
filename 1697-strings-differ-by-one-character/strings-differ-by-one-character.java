class Solution {

    static class TrieNode {
        TrieNode[] next = new TrieNode[26];
        boolean end = false;
    }

    TrieNode root;

    public boolean differByOne(String[] dict) {
        root = new TrieNode();

        for (String word : dict) {
            if (search(word, root, 0, 0)) {
                return true;
            }
            insert(word);
        }

        return false;
    }

    private boolean search(String word, TrieNode node, int idx, int mismatches) {
        if (node == null) return false;

        if (idx == word.length()) {
            return mismatches == 1 && node.end;
        }

        int c = word.charAt(idx) - 'a';

        if (node.next[c] != null) {
            if (search(word, node.next[c], idx + 1, mismatches)) {
                return true;
            }
        }

        if (mismatches == 0) {
            for (int k = 0; k < 26; k++) {
                if (k != c && node.next[k] != null) {
                    if (search(word, node.next[k], idx + 1, 1)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int c = ch - 'a';
            if (node.next[c] == null) {
                node.next[c] = new TrieNode();
            }
            node = node.next[c];
        }
        node.end = true;
    }
}