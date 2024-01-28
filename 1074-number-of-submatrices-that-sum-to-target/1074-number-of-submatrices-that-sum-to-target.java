class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
       
        int n = matrix.length;
        int m = matrix[0].length;
        
        // Preprocess the matrix to store the cumulative sum of each column
        for (int col = 0; col < m; ++col) {
            for (int row = 1; row < n; ++row) {
                matrix[row][col] += matrix[row-1][col];
            }
        }
        
        int count = 0; // Variable to store the count of submatrices with the target sum
        
        // Iterate over all possible pairs of rows c1 and c2
        for (int c1 = 0; c1 < n; ++c1) {
            for (int c2 = c1; c2 < n; ++c2) {
                // Map to store the frequency of cumulative sums for each column between c1 and c2
                Map<Integer, Integer> sumCount = new HashMap<>();
                sumCount.put(0, 1); // Initialize with 0 to account for the sum of the entire column
                
                int currentSum = 0; // Variable to store the cumulative sum for each column
                
                // Iterate over each column
                for (int col = 0; col < m; ++col) {
                    int colSum = matrix[c2][col] - (c1 > 0 ? matrix[c1 - 1][col] : 0);
                    currentSum += colSum; // Update cumulative sum for the current column
                    
                    // Check if there is a previous cumulative sum that, when subtracted from the current sum, gives the target
                    if (sumCount.containsKey(currentSum - target)) {
                        count += sumCount.get(currentSum - target); // Increment count with the frequency of the previous cumulative sum
                    }
                    
                    sumCount.put(currentSum, sumCount.getOrDefault(currentSum, 0) + 1); // Update the frequency of the current cumulative sum
                }
            }
        }
        
        return count; // Return the total count of submatrices with the target sum
    }
}
