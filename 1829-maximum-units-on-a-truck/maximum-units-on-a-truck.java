class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int total = 0;
        int n = boxTypes.length;
        int i = 0;
        
        while (i < n && truckSize > 0) {
            int unitsToBeTaken = Math.min(truckSize, boxTypes[i][0]);
            total += (unitsToBeTaken * boxTypes[i][1]);
            truckSize -= unitsToBeTaken;
            System.out.println(unitsToBeTaken);
            i++;
        }

        return total;
    }
}