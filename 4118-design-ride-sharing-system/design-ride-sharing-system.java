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

        ridersMap.remove(rider);

        int driver = drivers.pollFirst();

        return new int[] {driver, rider};

    }

    public void cancelRider(int riderId) {

        if (ridersMap.containsKey(riderId)) {
            ridersMap.put(riderId, false);
        }

    }

}