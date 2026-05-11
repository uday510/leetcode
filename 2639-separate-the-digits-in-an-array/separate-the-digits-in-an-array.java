class Solution {
    public int[] separateDigits(int[] nums) {
        
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            list.addAll(getDigits(num));
        }

        int[] res = new int[list.size()];
        for (int idx = 0; idx < res.length; idx++) {
            res[idx] = list.get(idx);
        } 

        return res;
    }

    private List<Integer> getDigits(int num) {
        List<Integer> list = new ArrayList<>();

        while (num > 0) {
            list.add(num % 10);
            num /= 10;
        }

        Collections.reverse(list);
        return list;
    }
}