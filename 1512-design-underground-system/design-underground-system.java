import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class UndergroundSystem {

    Map<Integer, List<Entry>> checkIns;
    Map<Integer, List<Entry>> checkOuts;
    Map<String, Trips> tripsMap;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        checkOuts = new HashMap<>();
        tripsMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.computeIfAbsent(id, k -> new ArrayList<>()).add(new Entry(id, stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {

        checkOuts.computeIfAbsent(id, k -> new ArrayList<>()).add(new Entry(id, stationName, t));

        Entry lastCheckIn = checkIns.get(id).getLast();
        String key = getKey(lastCheckIn.stn, stationName);

        tripsMap.computeIfAbsent(key, k -> new Trips());
        
        int currTrips = tripsMap.get(key).getNumTrips() + 1;
        int currSum = tripsMap.get(key).getTripsSum() + t - lastCheckIn.t;
        tripsMap.get(key).setNumTrips(currTrips);
        tripsMap.get(key).setTripsSum(currSum);
        
    }

    public double getAverageTime(String src, String dest) {
        Trips trips = tripsMap.get(getKey(src, dest));

        if (trips == null) return -1.0;

        return (double) trips.tripsSum / trips.numTrips;
    }

    private String getKey(String src, String dest) {
        return src + " -> " + dest;
    }

    class Trips {
        private int numTrips;
        private int tripsSum;

        Trips() {
            this.numTrips = 0;
            this.tripsSum = 0;
        }

        public int getNumTrips() {
            return numTrips;
        }

        public void setNumTrips(int numTrips) {
            this.numTrips = numTrips;
        }

        public int getTripsSum() {
            return tripsSum;
        }

        public void setTripsSum(int tripsSum) {
            this.tripsSum = tripsSum;
        }
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
