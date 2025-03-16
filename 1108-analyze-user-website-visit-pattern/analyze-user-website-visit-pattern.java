class Pair {
    int time;
    String website;

    Pair (int time, String website) {
        this.time = time;
        this.website = website;
    }
}
class Solution {
    public List<String> mostVisitedPattern(String[] usernames, int[] timestamp, String[] website) {
        Map<String, List<Pair>> users = new HashMap<>();

        for (int i = 0; i < usernames.length; ++i) {
            Pair p = new Pair(timestamp[i], website[i]);
            users.computeIfAbsent(usernames[i], k -> new ArrayList<>()).add(p);
        }

        Map<String, Integer> visitCount = new HashMap<>();
        for (var user : users.entrySet()) {
            String username = user.getKey();
            List<Pair> pairs = users.get(username);
            pairs.sort((o1, o2) -> o1.time - o2.time);
            Set<String> set = new HashSet<>();
            for (int i = 0; i < pairs.size() - 2; ++i) {
                for (int j = i + 1; j < pairs.size() - 1; ++j) {
                    for (int k = j + 1; k < pairs.size(); ++k) {
                        Pair p1 = pairs.get(i);
                        Pair p2 = pairs.get(j);
                        Pair p3 = pairs.get(k);

                        String key = p1.website + "_" + p2.website + "_" + p3.website;

                        if (set.add(key))
                            visitCount.merge(key, 1, Integer::sum);
                    }
                }
             }
        }
             int cnt = 0;
             String res = "";

             for (String key : visitCount.keySet()) {
                int count = visitCount.get(key);
                if (cnt < count || (cnt == count && key.compareTo(res) < 0)) {
                    res = key;
                    cnt = count;
                }
             }

             return Arrays.asList(res.split("_"));
    }
}