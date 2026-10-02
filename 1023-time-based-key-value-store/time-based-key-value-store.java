class TimeMap {

    Map<String, List<Node<String, Integer>>> hm;
    public TimeMap() {
        hm = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        hm.computeIfAbsent(key, k -> new ArrayList<>()).add(new Node(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        List<Node<String, Integer>> cur = hm.get(key);
        if (cur == null) return "";

        int l = 0, r = cur.size();
        String res = "";

        while (l < r) {
            int m = l + ((r - l) >> 1); 

            if (cur.get(m).t <= timestamp) {
                res = cur.get(m).v;
                l = m + 1;
            } else {
                r = m;
            }
        }

        return res;
    }    
}

class Node<K, V> {
    K v;
    V t;
    Node(K v, V t) {
        this.v = v;
        this.t = t;
    }
}
