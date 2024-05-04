class Solution {
    public int numRescueBoats(int[] people, int limit) {
       Arrays.sort(people);
        
        int leftIdx = 0;
        int rightIdx = people.length - 1;
        int totalRescueBoats = 0;
        
        while (leftIdx <= rightIdx) {
            if (people[leftIdx] + people[rightIdx] <= limit) {
                totalRescueBoats += 1;
                leftIdx++;
                rightIdx--;
            } else if (people[rightIdx] <= limit) {
                totalRescueBoats += 1;
                rightIdx--;
            } else if (people[leftIdx] <= limit) {
                totalRescueBoats += 1;
                leftIdx++;
            } else {
                totalRescueBoats += 2;
                leftIdx++;
                rightIdx--;
            }
        }
       
        return totalRescueBoats;
    }
}

