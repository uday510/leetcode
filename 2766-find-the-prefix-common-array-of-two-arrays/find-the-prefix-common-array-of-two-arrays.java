class Solution {

    public int[] findThePrefixCommonArray(int[] A, int[] B) {

        int n = A.length;
        Map<Integer, Integer> cnt = new HashMap<>();
        int[] res = new int[n];
        int common = 0;

        for (int i = 0; i < n; i++) {
            cnt.put(A[i], cnt.getOrDefault(A[i], 0) + 1);
            
            
            if (cnt.get(A[i]) == 2) common++;

            cnt.put(B[i], cnt.getOrDefault(B[i], 0) + 1);
            if (cnt.get(B[i]) == 2) common++;
            
            res[i] = common;
        }
        return res;
    }

}