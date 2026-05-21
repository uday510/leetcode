class Solution {

    public int[] findThePrefixCommonArray(int[] A, int[] B) {

        int n = A.length;
        Map<Integer, Integer> cnt = new HashMap<>();
        int[] res = new int[n];
        int common = 0;

        for (int i = 0; i < n; i++) {
            cnt.put(A[i], cnt.getOrDefault(A[i], 0) + 1);
            cnt.put(B[i], cnt.getOrDefault(B[i], 0) + 1);

            if (cnt.get(A[i]) == 2) common++;
            if (A[i] != B[i] && cnt.get(B[i]) == 2) common++;
            
            res[i] = common;
        }

        return res;
    }

}


/**

[1, 3, 2, 4] 1
[3, 1, 2, 4]

0: 0
1: 2
2: 3
3: 4

common = 1 + 1 + 1 + 1

cnt {

1: 2
3: 2
2: 2
4: 2

}

 */