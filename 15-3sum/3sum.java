class Solution {

    private int[] arr;
    private int n;

    public List<List<Integer>> threeSum(int[] nums) {
        arr = nums;
        n = nums.length;

        Arrays.sort(nums);

        return dfs(0, 3, 0);
    }

    private List<List<Integer>> dfs(int i, int k, int target) {

        if (k == 2) {
            return twoSum(i, target);
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int j = i; j < n; j++) {
            if (j > i && arr[j] == arr[j - 1]) continue;

            for (List<Integer> subList : dfs(j + 1, k - 1, target - arr[j])) {
                List<Integer> curList = new ArrayList<>();
                curList.add(arr[j]);
                curList.addAll(subList);

                res.add(curList);
            }

        }

        return res;
 
    }

    private List<List<Integer>> twoSum(int idx, int target) {
        List<List<Integer>> list = new ArrayList<>();

        int i = idx, j = n - 1;

        while (i < j) {
            int cur = arr[i] + arr[j];

            if (cur < target) i++;
            else if (cur > target) j--;
            else {
                list.add(new ArrayList<>(List.of(arr[i], arr[j])));
                
                i++; j--;
                while (i < n && arr[i] == arr[i - 1]) i++;
                while (j > -1 && arr[j] == arr[j + 1]) j--;
            } 
        }
        
        return list;
    }

}