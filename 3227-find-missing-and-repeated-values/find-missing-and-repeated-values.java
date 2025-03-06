class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int missingNumber = -1;
        
        Set<Integer> set = new TreeSet<>();
        for (int[] g : grid) {
            for (int num : g)  {
                if (set.contains(num)) {
                missingNumber = num;
                } else {
                 set.add(num);
                }
            }
        }
        
        System.out.println(set);
        int[] res = new int[2];
        res[0] = missingNumber;
         System.out.println(missingNumber);
        int idx = 1;
        for (int num : set) {
            if (num != idx) {
                res[1] = idx;
                break;
            }
            idx++;
        }
        if (res[1] == 0) res[1] = idx;
        return res;
    }
}