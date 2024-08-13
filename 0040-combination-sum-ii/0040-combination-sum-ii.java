class Solution {
    List<List<Integer>> list;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        list = new ArrayList<>();

        dfs(0, 0, candidates, target, new ArrayList<>());
        return list;
    }
    public void dfs(int i, int curr, int[] arr, int target, List<Integer> temp) {
         if (curr == target) {
            list.add(new ArrayList<>(temp));
            return;
        }

        if (i == arr.length) {
            return;
        }
    
        for (int j = i; j < arr.length; ++j) {
            if (curr + arr[j] > target  || j > i && arr[j] == arr[j-1]) {
                continue;
            }

            curr += arr[j];
            temp.add(arr[j]);
            dfs(j+1, curr, arr, target, temp);
            temp.remove(temp.size()-1);
            curr -= arr[j];
        }
    }
}