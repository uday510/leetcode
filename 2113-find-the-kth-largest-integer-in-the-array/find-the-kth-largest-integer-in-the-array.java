class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            if (a.length() != b.length()) return Integer.compare(a.length(), b.length());
            return a.compareTo(b);
        });

        for (String s : nums) {
            pq.offer(s);
            if (pq.size() > k) pq.poll();
        }

        return pq.peek();
    }
}