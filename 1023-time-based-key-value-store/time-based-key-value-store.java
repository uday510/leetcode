class TimeMap {

    Map<String, List<Pair<String, Integer>>> hm;
    public TimeMap() {
        hm = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        hm.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<String, Integer>> list = hm.get(key);

        timestamp++;

        if (list == null) return "";

        int l = 0;
        int r = list.size();

        while (l < r) {
            int m = (l + r) >> 1;
            if (list.get(m).v < timestamp) l = m + 1;
            else r = m;
        }

        if (l - 1 < 0 || l - 1 >= list.size()) return "";

        return list.get(l - 1).k;
    }

    class Pair<K, V> {
        K k;
        V v;

        Pair(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }

}