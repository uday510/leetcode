class Solution {
    public boolean canChange(String start, String target) {
        return bfs(start, target);
    }
     private boolean bfs(String start, String target) {
        Queue<Pair<Character, Integer>> startQueue = new LinkedList<>();
        Queue<Pair<Character, Integer>> targetQueue = new LinkedList<>();

        for (int idx = 0; idx < start.length(); ++idx) {
            char ch = start.charAt(idx);
            if (ch != '_') {
                startQueue.offer(new Pair<>(ch, idx));
            }
            ch = target.charAt(idx);
            if (ch != '_') {
                targetQueue.offer(new Pair<>(ch, idx));
            }
        }

        if (startQueue.size() != targetQueue.size()) {
            return false;
        }

        while (!startQueue.isEmpty() && !targetQueue.isEmpty()) {
            var st = startQueue.poll();
            var tg = targetQueue.poll();

            assert tg != null;
            if (st.ch != tg.ch || 
                (st.ch == 'L' && st.idx < tg.idx) || 
                (st.ch == 'R' && st.idx > tg.idx)) {
                    
                return false;
            }
        }

        return true;
    }
    
    private class Pair<T1, T2> {
        T1 ch;
        T2 idx;

        Pair(T1 ch, T2 idx) {
            this.ch = ch;
            this.idx = idx;
        }
    }
}