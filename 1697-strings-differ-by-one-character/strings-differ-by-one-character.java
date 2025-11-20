class Solution {

    TrieNode root;

    public boolean differByOne(String[] dict) {
        root = new TrieNode();

        for (String s : dict) {
            if (dfs(0, 0, s, root)) 
                return true;
            insert(s);
        }

        return false;
    }

    private boolean dfs(int i, int mismatches, String s, TrieNode node) {
        if (node == null) return false;

        if (i == s.length()) {
            return node.eow && mismatches == 1;
        }

        int idx = s.charAt(i) - 'a';

        for (int c = 0; c < 26; c++) {
            if (node.children[c] == null) continue;

            int newMismatch = mismatches + (c == idx ? 0 : 1);
            if (newMismatch <= 1) {
                if (dfs(i + 1, newMismatch, s, node.children[c])) {
                    return true;
                }
            }
        }        
        return false;
    }

    private void insert(String s) {
        TrieNode cur = root;
        for (int i = 0; i < s.length(); i++) {
             int idx = s.charAt(i) - 'a';
             if (cur.children[idx] == null) {
                cur.children[idx] = new TrieNode();
             }
             cur = cur.children[idx];
        }
        cur.eow = true;
    }
}

class TrieNode {

    TrieNode[] children;
    boolean eow;
    
    TrieNode () {
        children = new TrieNode[26];
        eow = false;
    }
}