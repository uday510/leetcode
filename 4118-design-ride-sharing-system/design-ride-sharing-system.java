class RideSharingSystem {

    Deque<Integer> riders;
    Deque<Integer> drivers;
    Set<Integer> activeRiders;

    public RideSharingSystem() {
        riders = new ArrayDeque<>();
        drivers = new ArrayDeque<>();
        activeRiders = new HashSet<>();
    }
    
    public void addRider(int riderId) {
        riders.offerLast(riderId);
        activeRiders.add(riderId);
    }
    
    public void addDriver(int driverId) {
        drivers.offerLast(driverId);
    }
    
    public int[] matchDriverWithRider() {
        if (riders.isEmpty() || drivers.isEmpty()) {
            return new int[] {-1, -1};
        }

        while (!riders.isEmpty() && 
               !activeRiders.contains(riders.peekFirst())) {
            riders.pollFirst();    
        }

        if (riders.isEmpty()) {
            return new int[] {-1, -1};
        }

        int rider = riders.pollFirst();
        int driver = drivers.pollFirst();

        activeRiders.remove(rider);

        return new int[] {driver, rider};

    }

    public void cancelRider(int riderId) {
        activeRiders.remove(riderId);
    }

}