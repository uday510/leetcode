class Solution {
    public String smallestEquivalentString(String s1, String s2, String base) {
        int n = s1.length();
        DSU dsu = new DSU(26);

        for (int i = 0; i < n; i++) {
            dsu.union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int c1 = s1.charAt(i) - 'a', c2 = s2.charAt(i) - 'a';
            int r1 = dsu.find(c1), r2 = dsu.find(c2);

            if (map.containsKey(r1)) {
                map.put(r1, Math.min(map.get(r1), Math.min(c1, c2)));
            } else {
                map.put(r1, Math.min(c1, c2));
            }

            if (map.containsKey(r2)) {
                map.put(r2, Math.min(map.get(r2), Math.min(c1, c2)));
            } else {
                map.put(r2, Math.min(c1, c2));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < base.length(); i++) {
            char c = base.charAt(i);
            int r = dsu.find(c - 'a');

            if (map.containsKey(r)) {
                sb.append((char) (map.get(r) + 'a'));
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}


class DSU {
    int[] rank;
    int[] root;


    DSU (int n) {
        rank = new int[n];
        root = new int[n];

        for (int i = 0; i < n; i++) {
            rank[i] = 1;
            root[i] = i;
        }
    }

    int find(int x) {
        if (x == root[x]) 
            return x;
        return root[x] = find(root[x]);
    }

    void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);

        if (rx == ry)
            return;
        
        if (rank[rx] > rank[ry]) {
            root[ry] = rx;
        } else if (rank[ry] > rank[rx]) {
            root[rx] = ry;
        } else {
            rank[x]++;
            root[ry] = rx;
        }
    }
}

/**


p: p m
a: a o
r: r k s
i: e i

----


p: p
a: a
r: r
k: r
e: i
r: r

m: p
o: a
r: r
r: r
i: i
s: r

Input: s1 = "parker", s2 = "morris", baseStr = "parser"

Output: "makkek"

Explanation: Based on the equivalency information in s1 and s2, we can group their characters as [m,p], [a,o], [k,r,s], [e,i].
The characters in each group are equivalent and sorted in lexicographical order.
So the answer is "makkek".




 */