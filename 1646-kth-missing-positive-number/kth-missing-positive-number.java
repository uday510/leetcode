class Solution {
    public int findKthPositive(int[] arr, int k) {
        Set<Integer> set = new HashSet<>();

        for (int val : arr) set.add(val);

        int missing = 0;
        int i;
        for (i = 1; missing < k; i++) {
            if (!set.contains(i)) missing++;
        }
        
        return i-1;
    }

}

/**

[1 2 3 4 5 6 7 8 9 10 11] 

missing [1 5 6 8 9 10 ...] 

2 3 4 7 11

 */