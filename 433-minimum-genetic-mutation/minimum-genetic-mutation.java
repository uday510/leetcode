class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        
        Set<String> set = new HashSet<>(Arrays.asList(bank));
        Queue<String> queue = new ArrayDeque<>();
        int level = 0;
        queue.offer(startGene);

        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int idx = 0; idx < size; ++idx) {
                String curr = queue.poll();
                StringBuilder sb = new StringBuilder(curr);

                for (int i = 0; i < curr.length(); ++i) {
                    char prev = sb.charAt(i);

                    for (char ch : new char[]{'A', 'C', 'G', 'T'}) {
                        sb.setCharAt(i, ch);

                        String gene = sb.toString();

                        if (!set.contains(gene)) continue;
                        
                        if (gene.equals(endGene)) return level;
                    
                        set.remove(gene);
                        queue.offer(gene);
                    }
                    sb.setCharAt(i, prev);
                }
            }
        }
        return -1;
    }
}