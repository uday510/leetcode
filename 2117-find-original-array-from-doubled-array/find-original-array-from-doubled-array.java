class Solution {
    public int[] findOriginalArray(int[] C) {
        if ((C.length & 1) == 1) return new int[] {};

        Arrays.sort(C);

        int n = C.length;
        int[] A = new int[n / 2];
        int idx = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : C) map.merge(i, 1, Integer::sum);

        for (int a : C) {
            if (map.get(a) > 0) {
                map.merge(a, -1, Integer::sum);

                Integer dCnt = map.get(a * 2);

                if (dCnt == null || dCnt == 0) return new int[] {};

                map.merge(a * 2, -1, Integer::sum);

                A[idx++] = a; 
            }
        }

        return A;
    }
}