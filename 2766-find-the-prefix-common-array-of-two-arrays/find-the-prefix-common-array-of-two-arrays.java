class Solution {

    public int[] findThePrefixCommonArray(int[] A, int[] B) {

        int n = A.length;
        Map<Integer, Integer> cnt = new HashMap<>();
        int[] res = new int[n];
        
        for (int i = 0; i < n; i++) {
            int a = A[i], b = B[i];
            
            cnt.put(a, cnt.getOrDefault(a, 0) + 1);
            cnt.put(b, cnt.getOrDefault(b, 0) + 1);
            
            int cur = 0;
            for (int j = 0; j <= i; j++) {
                if (cnt.get(A[j]) == 2) cur++;
                if (cnt.get(B[j]) == 2) cur++;
            }
            
            res[i] = cur / 2;
        }
        
        return res;
    }


}