class Solution {

    public int minMutation(String st, String en, String[] bank) {

        if (st.equals(en))
            return 0;

        Queue<String> queue = new ArrayDeque<>();
        Set<String> valid = new HashSet<>(List.of(bank));

        if (!valid.contains(en))
            return -1;


        char[] chars = new char[] {'A', 'C', 'G', 'T'};
        int mts = 0;
        
        valid.remove(st);
        queue.offer(st);
        while (!queue.isEmpty()) {

            mts++;
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                String s = queue.poll();
                char[] ch = s.toCharArray();
                
                for (int j = 0; j < ch.length; j++) {
                   char old = s.charAt(j);

                    for (char c : chars) {
                        ch[j] = c;
                        String gene = new String(ch);

                        if (c == old || !valid.contains(gene))
                            continue;

                        if (gene.equals(en))
                            return mts;

                        valid.remove(gene);
                        queue.offer(gene);
                    }

                    ch[j] = old;                
                }
            }
        }
        
        return -1;
    }

}