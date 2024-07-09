class Solution {
    public double averageWaitingTime(int[][] customers) {
        double waitTime = 0;
        int start = customers[0][0];
        
        for (int[] customer : customers) {
            int arrival = customer[0];
            int time = customer[1];
            waitTime += Math.max(0, start - arrival) + time;
            
            start = Math.max(start, arrival) + time;
        }
        
        return (waitTime / customers.length);
    }
}