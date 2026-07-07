class Solution {
    public long sumAndMultiply(int n) {
        
        Deque<Integer> queue = new ArrayDeque<>();

        while (n > 0) {
            int c = n % 10;
            if (c != 0) {
                queue.offerFirst(c);
            }

            n /= 10;
        }


        long t = 0, s = 0;
        for (int i : queue) {
            t += i;
            s *= 10;
            s += i;

        }
        
        return s * t;
    }
}