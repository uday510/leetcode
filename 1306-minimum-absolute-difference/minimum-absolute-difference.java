class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> list = new ArrayList<>();
        
        int min = (int) 1e9;
        
        for (int i = 1; i < arr.length; ++i) {
            min = Math.min(min, arr[i] - arr[i - 1]);
        }
        
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i] - arr[i - 1] == min) {
                list.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }

        return list;
    }
}