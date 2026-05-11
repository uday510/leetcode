class Solution {

    public int[] separateDigits(int[] nums) {
        
        List<Integer> res = new ArrayList<>();

        for (int num : nums) {
            res.addAll(getDigits(num));
        }

        int[] arr = new int[res.size()];

        for (int idx = 0; idx < arr.length; idx++) {
            arr[idx] = res.get(idx);
        }

        return arr;
    }

    private List<Integer> getDigits(int num) {
        
        // num = 13
        List<Integer> list = new ArrayList<>(); // 1, 3

        while (num > 0) {
            list.add(num % 10); 
            num /= 10;
        }

        Collections.reverse(list);

        return list;
    }

}

/**

[13,25,83,77]


13 --> 

[3, 1] -> reverse -> [1, 3] 
13 % 10 = 3
13 / 10 = 1

---
1 % 10 = 1
1 / 10 = 0


*/

