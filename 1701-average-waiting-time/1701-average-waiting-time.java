class Solution {
    public double averageWaitingTime(int[][] customers) {
         double waitTime = 0;
         int currentTime = 0;
        
        for (int[] customer : customers) {
            int arrivalTime = customer[0];
            int cookTime = customer[1];
            
            if (currentTime < arrivalTime) {
                currentTime = arrivalTime;
            }
            
            currentTime += cookTime;
            waitTime += currentTime - arrivalTime;
        }
        
        return waitTime / customers.length;
    }
}