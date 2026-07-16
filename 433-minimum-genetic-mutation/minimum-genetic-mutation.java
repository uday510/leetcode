class Solution {
    
    public int minMutation(String startGene, String endGene, String[] bank) {

        if (startGene.equals(endGene))
            return 0;
        
        Set<String> validGenes = new HashSet<>(List.of(bank));
        char[] validChars = new char[] {'A', 'C', 'G', 'T'};
        
        if (!validGenes.contains(endGene))
            return -1;
        
        Queue<String> queue = new ArrayDeque<>();
        
        validGenes.remove(startGene);
        queue.offer(startGene);
        
        int mutations = 0;
        while (!queue.isEmpty()) {
            mutations++;
            
            int sz = queue.size();
            
            for (int idx = 0; idx < sz; idx++) {
                char[] chars = Objects.requireNonNull(queue.poll()).toCharArray();
                System.out.println(Arrays.toString(chars));
                
               
                for (int j = 0; j < chars.length; j++) {

                    char old = chars[j];

                    for (char c : validChars) {
                        if (old == c) continue;
                        
                        chars[j] = c;
                        String gene = new String(chars);
                        
                        if (!validGenes.contains(gene))
                            continue;
                        
                        if (gene.equals(endGene))
                            return mutations;
                        
                        validGenes.remove(gene);
                        queue.offer(gene);
                    }
                    
                    chars[j] = old;
                }
                
            }
        }
        
        return -1;
    }
}