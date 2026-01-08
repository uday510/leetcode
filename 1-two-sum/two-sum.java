class Solution {
    public int[] twoSum(int[] A, int T) {
        
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            int curSum = T - A[i];

            if (map.containsKey(curSum)) {
                return new int[] {map.get(curSum), i};
            }

            map.put(A[i], i);
        }

        return new int[] {-1, -1};
    }
}