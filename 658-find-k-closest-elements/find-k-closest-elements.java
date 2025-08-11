class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        List<Integer> list = new ArrayList<>();
        for (int num : arr) list.add(num);

        list.sort((a, b) -> Math.abs(a - x) - Math.abs(b - x));

        list = list.subList(0, k);
        Collections.sort(list);

        return list;
    }
}