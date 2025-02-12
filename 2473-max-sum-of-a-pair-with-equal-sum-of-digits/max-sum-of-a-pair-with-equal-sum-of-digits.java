class Solution {
    public int maximumSum(int[] nums) {
        
        TreeMap<Integer, List<Integer>> map = new TreeMap<>((o1, o2) -> Integer.compare(o2, o1));


        for (int num : nums) {
            int digitSum = getDigitSum(num);

            map.computeIfAbsent(digitSum, i -> new ArrayList<>()).add(num);
        }

        int max = -1;
        for (var entry : map.entrySet()) {
            if (entry.getValue().size() < 2) 
                continue;
            
            var values = entry.getValue();
            Collections.sort(values);

            System.out.println(entry);
            System.out.println(values);

            max = Math.max(max, values.get(values.size() - 1) + values.get(values.size() - 2));
        }


       return max;
    }

    private int getDigitSum(int num) {

        int sum = 0;
        int curr = num;

        while (curr > 0) {
            sum += curr % 10;
            curr /= 10;
        }

        return sum;
    }
}