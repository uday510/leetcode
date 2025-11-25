class Solution {

    private Trie root;

    public boolean differByOne(String[] dict) {
        
        root = new Trie();

        for (String s : dict) {
            if (dfs(s, root, 0, 0)) return true;
            insert(s);
        }

        return false;
    }

    private boolean dfs(String s, Trie cur, int i, int mismatches) {
        if (cur == null) return false;

        if (i == s.length()) return cur.eow && mismatches == 1;

        int idx = s.charAt(i) - 'a';

        for (int c = 0; c < 26; c++) {
            Trie nxt = cur.children[c];
            if (nxt == null) continue;

            int newMismatches = mismatches + (c == idx ? 0 : 1);
            if (newMismatches <= 1) {
                if (dfs(s, nxt, i + 1, newMismatches)) {
                    return true;
                }
            }
        }

        return false;
    }

    private void insert(String s) {
        Trie cur = root;

        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';

            if (cur.children[idx] == null) {
                cur.children[idx] = new Trie();
            }
            
            cur = cur.children[idx];
        }

        cur.eow = true;
    }
}

class Trie {
    Trie[] children;
    boolean eow;

    Trie () {
        children = new Trie[26];
        eow = false;
    }

}