class Solution {
    public String largestNumber(int[] nums) {
        int N = nums.length;
        String[] arr = new String[N];

        for (int i = 0; i < N; ++i) {
            arr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(arr, (s1, s2) -> (s2+s1).compareTo(s1+s2));

        if (arr[0].startsWith("0")) 
            return "0";

        StringBuilder sb = new StringBuilder();

        for (String s : arr) {
            sb.append(s);
        }

        return sb.toString();
    }
}