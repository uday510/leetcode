class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] res = new int[n];
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        for (int i = 0; i < n; i++) {
            setA.add(A[i]);
            setB.add(B[i]);

            int common = 0;
            for (int num : setA) {
                if (setB.contains(num)) common++;
            }

            res[i] = common;
        }

        return res;
    }
}

/**

setA: 1

setB: 3

A: 1
B: 3

 */