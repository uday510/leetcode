class UndergroundSystem {

    Map<Integer, List<Entry>> checkIns;
    Map<Integer, List<Entry>> checkOuts;
    Map<String, List<Integer>> times;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        checkOuts = new HashMap<>();
        times = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkIns.computeIfAbsent(id, k -> new ArrayList<>()).add(new Entry(id, stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        
        checkOuts.computeIfAbsent(id, k -> new ArrayList<>()).add(new Entry(id, stationName, t));

        Entry lastCheckIn = checkIns.get(id).getLast();
        String key = getKey(lastCheckIn.stn, stationName);

        times.computeIfAbsent(key, k -> new ArrayList<>()).add(t - lastCheckIn.t);
    }
    
    public double getAverageTime(String src, String dest) {
        List<Integer> list = times.get(getKey(src, dest));

        if (list == null) return -1.0;

        int sum = 0;
        for (var t : list) sum += t;

        return (double) sum / list.size();
    }

    private String getKey(String src, String dest) {
        return src + " -> " + dest;
    }

    class Entry {
        int id;
        String stn;
        int t;

        Entry (int id, String stn, int t) {
            this.id = id;
            this.stn = stn;
            this.t = t;
        }
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */