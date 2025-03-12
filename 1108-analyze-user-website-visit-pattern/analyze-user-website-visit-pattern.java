class Pair {
    String u;
    int t;
    String w;

    Pair(String _u, int _t, String _w) {
        this.u = _u;
        this.t = _t;
        this.w = _w;
    }
}

class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Pair>> pairs = new HashMap<>();
        int len = username.length;

        for (int idx = 0; idx < len; ++idx) {
            String u = username[idx];
            int t = timestamp[idx];
            String w = website[idx];

            pairs.computeIfAbsent(u, k -> new ArrayList<>()).add(new Pair(u, t, w));
        }

        Map<String, Integer> map = new HashMap<>();

        for (var user : pairs.keySet()) {
            List<Pair> list = pairs.get(user);
            list.sort(Comparator.comparingInt(p -> p.t));

            Set<String> set = new HashSet<>();

            for (int i = 0; i < list.size() - 2; ++i) {
                Pair p1 = list.get(i);
                for (int j = i + 1; j < list.size() - 1; ++j) {
                    Pair p2 = list.get(j);
                    for (int k = j + 1; k < list.size(); ++k) {
                        Pair p3 = list.get(k);

                        String key = p1.w + " " + p2.w + " " + p3.w;

                        if (set.add(key)) {
                            map.merge(key, 1, Integer::sum);
                        }
                    }
                }
            }
        }

        String res = "";
        int cnt = 0;

        for (String key : map.keySet()) {
            int val = map.get(key);

            if (val > cnt || (val == cnt && key.compareTo(res) < 0)) {
                res = key;
                cnt = val;
            }
        }


        return Arrays.asList(res.split(" "));
    }
}