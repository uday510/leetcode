class RideSharingSystem {

    Deque<Integer> riders;
    Deque<Integer> drivers;
    Map<Integer, Boolean> ridersMap;

    public RideSharingSystem() {
        riders = new ArrayDeque<>();
        drivers = new ArrayDeque<>();
        ridersMap = new HashMap<>();
    }
    
    public void addRider(int riderId) {
        riders.offerLast(riderId);
        ridersMap.put(riderId, true);
    }
    
    public void addDriver(int driverId) {
        drivers.offerLast(driverId);
    }
    
    public int[] matchDriverWithRider() {
        if (riders.isEmpty() || drivers.isEmpty()) {
            return new int[] {-1, -1};
        }

        while (!riders.isEmpty() && !ridersMap.get(riders.peekFirst())) {
            riders.remove(riders.pollFirst());    
        }

        if (riders.isEmpty()) {
            return new int[] {-1, -1};
        }

        int rider = riders.pollFirst();

        int driver = drivers.pollFirst();

        return new int[] {driver, rider};

    }

    public void cancelRider(int riderId) {

        if (ridersMap.containsKey(riderId)) {
            ridersMap.put(riderId, false);
        }

    }

}

/**
 * Your RideSharingSystem object will be instantiated and called as such:
 * RideSharingSystem obj = new RideSharingSystem();
 * obj.addRider(riderId);
 * obj.addDriver(driverId);
 * int[] param_3 = obj.matchDriverWithRider();
 * obj.cancelRider(riderId);
 */

 /**
 
 riders : 1

 drives : 1

 cancelled: 1

 
  */