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

    private boolean dfs(String s, Trie cur, int i, int mis) {

        if (cur == null) return false;

        if (i == s.length()) return cur.eow && mis == 1;

        int idx = s.charAt(i) - 'a';

        for (int c = 0; c < 26; c++) {
            Trie nxt = cur.chi[c];

            if (nxt == null) continue;

            int newM = mis + (c == idx ? 0 : 1);
            if (newM <= 1) {
                if (dfs(s, nxt, i + 1, newM)) {
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

            if (cur.chi[idx] == null) {
                cur.chi[idx] = new Trie();
            }

            cur = cur.chi[idx];
        }

        cur.eow = true;
    }
}

class Trie {
    Trie[] chi;
    boolean eow;

    Trie () {
        chi = new Trie[26];
        eow = false;
    }
}