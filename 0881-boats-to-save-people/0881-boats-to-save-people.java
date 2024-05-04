class Solution {
    public int numRescueBoats(int[] people, int limit) {
       Arrays.sort(people);
        
        int leftIdx = 0;
        int rightIdx = people.length - 1;
        int totalRescueBoats = 0;
        
        while (leftIdx <= rightIdx) {
            if (people[leftIdx] + people[rightIdx] <= limit) {
                leftIdx++;
                rightIdx--;
            } else if (people[rightIdx] <= limit) {
                rightIdx--;
            } else {
                ++totalRescueBoats;
                leftIdx++;
                rightIdx--;
            }
            ++totalRescueBoats;
        }
       
        return totalRescueBoats;
    }
}

