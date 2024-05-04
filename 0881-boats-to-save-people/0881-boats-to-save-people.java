class Solution {
    public int numRescueBoats(int[] people, int limit) {
       Arrays.sort(people);
        
        int leftIdx = 0;
        int rightIdx = people.length - 1;
        int totalRescueBoats = 0;
        
        while (leftIdx <= rightIdx) {
           int weight = people[leftIdx] + people[rightIdx];
            
            if (weight <= limit) {
                ++leftIdx;
            }
            
            ++totalRescueBoats;
            --rightIdx;
        }
        
        return totalRescueBoats;
    }
}

