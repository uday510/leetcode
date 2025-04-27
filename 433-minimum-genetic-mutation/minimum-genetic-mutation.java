class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> validGenes = new HashSet<>(Arrays.asList(bank));
        Queue<String> queue = new ArrayDeque<>();
        int mutations = 0;

        if (!validGenes.contains(endGene)) return -1;
        queue.offer(startGene);

        while (!queue.isEmpty()) {
            int size = queue.size();
            mutations++;
            for (int idx = 0; idx < size; ++idx) {
                String currentGene = queue.poll();
                StringBuilder geneBuilder = new StringBuilder(currentGene);

                for (int pos = 0; pos < currentGene.length(); ++pos) {
                    char originalChar = geneBuilder.charAt(pos);

                    for (char ch : new char[]{'A', 'C', 'G', 'T'}) {
                        geneBuilder.setCharAt(pos, ch);

                        String mutatedGene = geneBuilder.toString();

                        if (!validGenes.contains(mutatedGene)) continue;
                        
                        if (mutatedGene.equals(endGene)) return mutations;
                    
                        validGenes.remove(mutatedGene);
                        queue.offer(mutatedGene);
                    }
                    geneBuilder.setCharAt(pos, originalChar);
                }
            }
        }
        return -1;
    }
}