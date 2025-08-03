class TimeMap {

    Map<String, Map<String, Integer>> hm;
    public TimeMap() {
        hm = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        hm.computeIfAbsent(key, x -> new HashMap<>()).put(value, timestamp);
    }
    
    public String get(String key, int timestamp) {
        Map<String, Integer> map = hm.get(key);

        if (map == null) return "";

        int prev = Integer.MIN_VALUE;
        String res = "";
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            String k = e.getKey();
            int v = e.getValue();

            if (v <= timestamp && v > prev) {
                prev = v;
                res = k;
            }
        }

        return res;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */