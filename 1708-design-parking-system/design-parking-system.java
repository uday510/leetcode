class ParkingSystem {

    Map<Integer, int[]> parkingLot;

    public ParkingSystem(int big, int medium, int small) {
       parkingLot = new HashMap<>();

       initLot(1, big);
       initLot(2, medium);
       initLot(3, small);
    }
    private void initLot(int type, int capacity) {
        parkingLot.put(type, new int[2]);
        parkingLot.get(type)[0] = capacity;
    }
    
    public boolean addCar(int carType) {
        int[] arr = parkingLot.get(carType);

        if (arr[0] == arr[1]) return false;

        arr[1]++;
        
        return true;
    }

}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */