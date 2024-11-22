class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        int N = nums1.length;
        int M = nums2.length;

        for (int j = 0; j < M; ++j) {
            priorityQueue.offer(new int[]{nums1[0] + nums2[j], 0, j});
        }

        while (k-- > 0 && !priorityQueue.isEmpty()) {
            int[] arr = priorityQueue.poll();
            int i = arr[1];
            int j = arr[2];

            list.add(new ArrayList<>(Arrays.asList(nums1[i], nums2[j])));

            int nextI = i + 1;
            int nextJ = j;

            if (nextI < N) {
                priorityQueue.offer(new int[]{nums1[nextI] + nums2[nextJ], nextI, nextJ});
            }
        }

        return list;
    }
}