class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char t : tasks) freq[t - 'A']++;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int f : freq) {
            if (f > 0) pq.offer(f);
        }

        int time = 0;
        
        while (!pq.isEmpty()) {
            int cycle = n + 1, cnt = 0;
            List<Integer> list = new ArrayList<>();
            while (cycle-- > 0 && !pq.isEmpty()) {
                int cur = pq.poll();
                if (cur > 1) list.add(cur - 1);
                cnt++;
            }

            for (int t : list) pq.offer(t);

            time += (pq.isEmpty() ? cnt : n + 1);
        }

        return time;
    }
}

/**

n = 2
A -> 3
B -> 3




A->B->idle->A->B->idle->A->B
Input: tasks = ["A","A","A","B","B","B"], n = 2

1   2   3   4       5                   6       
A   B   C   D   (5-1>=n)allow A         (6-2 >= n)ALLOW B


total 6 intervals without any idle


--------------------------
Input: tasks = ["A","A","A","B","B","B"], n = 2
               
A->B->wait->A->B->wait->A->B => 8   

-------------------------
Input: tasks = ["A","A","A", "B","B","B"], n = 3

A->B->wait->wait->A->B->wait->wait->A->B => 10




--------------

A:3
B:3
n = 2


res = 0

taskCnt = 2

A:2
B:2



*/

// 3 > 0 2 > 0, 1 > 0