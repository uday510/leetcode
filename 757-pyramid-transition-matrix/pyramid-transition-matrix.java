class Solution {

    private Map<String, List<Character>> map = new HashMap<>();
    private int idx;
    private String k;

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        map.clear();

        for (String s : allowed) {
            String k = s.substring(0, 2);
            char v = s.charAt(2);
            map.computeIfAbsent(k, _ -> new ArrayList<Character>()).add(v);
        }

        return dfs(bottom, "");
    }

    private boolean dfs(String cur, String nxt) {
        if (cur.length() == 1) return true;

        if (nxt.length() + 1 == cur.length()) return dfs(nxt, "");

        idx = nxt.length();
        k = cur.substring(idx, idx + 2);

        if (!map.containsKey(k)) return false;

        for (char c : map.get(k)) {
            if (dfs(cur, nxt + c)) return true;
        }

        return false;
    }
}

/**

BC : [C]
CD : [E]
CE : [A]
FF : [F]


dfs("BCD", "")


BC --> [C]
dfs("BCD", "C")

CD -> [E]

dfs("BCD", "CE")

--> 
dfs("CE", "")

CE -> [A]

dfs("CE", "A")

dfs("A", "")

*/