class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        
        int[] output = new int[arr1.length];
        for (int num : arr1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int index = 0;
        for (int i = 0; i < arr2.length; ++i) {
            int current = arr2[i];
            set.add(current);
            
            while (map.get(current) > 0) {
                output[index++] = current;
                map.put(current, map.get(current) - 1);
            }
        }
        
        List<Integer> list = new ArrayList<>();
        for (int num : arr1) {
            if (!set.contains(num))
                list.add(num);
        }
        Collections.sort(list);
        
        for (int num : list) {
            output[index++] = num;
        }
        
        return output;
    }
}