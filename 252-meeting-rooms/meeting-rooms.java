class Solution {
    public boolean canAttendMeetings(int[][] I) {
        
        Arrays.sort(I, (o1, o2) -> o1[0] - o2[0]);

        for (int i = 0; i < I.length - 1; i++) {
            if (I[i][1] > I[i + 1][0]) return false;
        }

        return true;
    }
}