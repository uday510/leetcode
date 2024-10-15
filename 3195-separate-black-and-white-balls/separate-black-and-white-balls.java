class Solution {
    public long minimumSteps(String s) {
        String[] arr = s.split("");
        int leftIdx = 0;
        int rightIdx = arr.length - 1;

        long swaps = 0;

        while (leftIdx < rightIdx) {
            while (rightIdx > -1 && arr[rightIdx].equals("1")) {
                    --rightIdx;
            }
            while (leftIdx < arr.length && arr[leftIdx].equals("0")) {
                    ++leftIdx;
            }
            if (leftIdx < rightIdx && arr[leftIdx].equals("1")) {
                swaps += (rightIdx - leftIdx);
                String tmp = arr[leftIdx];
                arr[leftIdx] = arr[rightIdx];
                arr[rightIdx] = tmp;
                ++leftIdx;
            }
        }
        return swaps;
    }
}