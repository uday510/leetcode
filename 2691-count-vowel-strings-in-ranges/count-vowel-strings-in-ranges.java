class Solution {
    int[] pf;
    int[] result;
    public int[] vowelStrings(String[] words, int[][] queries) {
        intialize(words, queries);
        System.out.println(Arrays.toString(pf));
        for (int idx = 0; idx < queries.length; ++idx) {
            int[] query = queries[idx];

            int current = pf[query[1]];
            if (query[0] != 0) {
                current -= pf[query[0] - 1];
            }

            result[idx] = current;
        }
        return result;
    }
    private void intialize(String[] words, int[][] queries) {
        pf = new int[words.length];
        result = new int[queries.length];

        pf[0] = isWordVowel(words[0]) ? 1 : 0;

        for (int idx = 1; idx < words.length; ++idx) {
            String word = words[idx];

            pf[idx] = pf[idx - 1] + (isWordVowel(word) ? 1 : 0);
        }
    }
    private boolean isWordVowel(String word) {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Input is Empty");
        }

        char first = word.charAt(0);
        char second = word.charAt(word.length() - 1);

        return isVowel(first) && isVowel(second);
    }
    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'; 
    }
   
}