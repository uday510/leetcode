class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int maxWaterBottles = numBottles;
        int currBottles = numBottles;
        
        while (currBottles >= numExchange) {
            int newBottles = currBottles / numExchange;
            maxWaterBottles += newBottles;
            currBottles = newBottles + (currBottles % numExchange);
        }
        return maxWaterBottles;
    }
}