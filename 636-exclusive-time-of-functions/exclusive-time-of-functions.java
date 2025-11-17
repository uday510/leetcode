class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Deque<Integer> st = new ArrayDeque<>();
        int prevTime = 0;

        int[] res = new int[n];

        for (int i = 0; i < logs.size(); i++) {
            String[] parts = logs.get(i).split(":");
            int id = Integer.parseInt(parts[0]);
            int time = Integer.parseInt(parts[2]);
            boolean isStart = parts[1].charAt(0) == 's';

            if (isStart) {
                if (!st.isEmpty()) {
                    res[st.peek()] += time - prevTime;
                }
                st.push(id);
                prevTime = time;
            } else {
                res[st.pop()] += time - prevTime + 1;
                prevTime = time + 1;
            }
        }

        return res;
    }
}