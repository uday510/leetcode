class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        int[] result = new int[A.length];


        for (int idx = 0; idx < A.length; ++idx) {
            set1.add(A[idx]);
            set2.add(B[idx]);

            result[idx] = countCommon(set1, set2);
        }
        return result;
    }

    private int countCommon(Set<Integer> set1, Set<Integer> set2) {

        int count = 0;

        for (var num : set2) {
            if (set1.contains(num)) {
                count++;
            }
        }

        return count;
    }
}


/**

[1, 3, 2, 4]
[3, 1, 2, 4]

[0, 0, 0, 0]

 */