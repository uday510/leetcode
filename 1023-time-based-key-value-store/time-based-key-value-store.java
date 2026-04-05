class TimeMap {

    Map<String, List<Node>> hm;
    
    public TimeMap() {
        hm = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        hm.computeIfAbsent(key, _ -> new ArrayList<Node>()).add(new Node(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        var cur = hm.get(key);

        if (cur == null) return "";

        int l = 0, r = cur.size();
        String res = "";

        while (l < r) {
            int m = l + (r - l) / 2;

            if (cur.get(m).timestamp <= timestamp) {
                res = cur.get(m).value;
                l = m + 1;
            }
            else r = m;
        }

        return res;
    }
}

class Node {
    String value;
    int timestamp;

    Node (String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    } 

}