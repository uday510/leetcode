class Solution {
    public int[] findOriginalArray(int[] arr) {
        int n = arr.length;
        if (n <= 1 || n % 2 == 1) return new int[]{};

        Map<Integer, Integer> map = new HashMap<>();

        Arrays.sort(arr);

        for (int num : arr) map.put(num, map.getOrDefault(num, 0) + 1);

        int[] res = new int[n/ 2];
        int i = 0;

        for (int a : arr) {
            int aCnt = map.get(a);
            if (aCnt == 0) continue;

            map.put(a, aCnt - 1);

            int d = a * 2;
            Integer dCnt = map.get(d);
            if (dCnt == null || dCnt == 0) return new int[] {};

            map.put(d, dCnt - 1);
            
            res[i++] = a;
        }

        return res;
    }
}

// [0, 0, 0, 1]

// 0 : 1
// 1 : 1


// [0, 0]