class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int len = obstacles.length;
        int[] result = new int[len];
        List<Integer> lis = new ArrayList<>();

        for (int idx = 0; idx < len; ++idx) {
            int obstacle = obstacles[idx];

            if (lis.isEmpty() || obstacle >= lis.getLast()) {
                lis.add(obstacle);
                result[idx] = lis.size();
            } else {
                int j = bs(lis, obstacle);
                lis.set(j, obstacle);
                result[idx] = j + 1;
            }
        }
        return result;
    }
    private  int bs(List<Integer> lis, int num) {
        int left = 0;
        int right = lis.size();
        
        while (left < right) {
            int mid = (left + right) >> 1;
            
            if (lis.get(mid) <= num) 
                left = mid + 1;
            else 
                right = mid;
        }
        
        return left;
    }
}