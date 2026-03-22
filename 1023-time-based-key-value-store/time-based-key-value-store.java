class TimeMap {

    Map<String, List<Pair<String, Integer>>> hm;

    public TimeMap() {
        hm = new HashMap<>();    
    }
    
    public void set(String key, String value, int timestamp) {
        hm.computeIfAbsent(key, _ -> new ArrayList<>()).add(new Pair<>(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        var cur = hm.get(key);

        if (cur == null) return "";

        int l = 0, r = cur.size();

        while (l < r) {
            int m = (l + r) >> 1;
            if (cur.get(m).v <= timestamp) l = m + 1;
            else r = m;
        }
        
        timestamp++;

        if (l - 1 < 0 || l - 1 >= cur.size()) return "";

        return cur.get(l - 1).k;
    }
}


class Pair<K, V> {
    K k;
    V v;

    Pair (K k, V v) {
        this.k = k;
        this.v = v;
    }
}