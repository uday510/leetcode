class Solution {

    int[] freq;
    List<String> result;

    public List<String> wordSubsets(String[] words1, String[] words2) {
        intialize(words2);

        for (String str : words1) {
            if (universalString(str)) {
                result.add(str);
            }
        }

        return result;
    }

    private void intialize(String[] words) {
        freq = new int[26];
        result = new ArrayList<>();

        for (String str : words) {
            countFreq(str);
        }
    }

    private void countFreq(String str) {
        int[] temp = new int[26];

        for (char ch : str.toCharArray()) {
            temp[ch - 'a']++;
        }

        for (int idx = 0; idx < 26; ++idx) {
            freq[idx] = Math.max(freq[idx], temp[idx]);
        }
    }

    private boolean universalString(String str) {
        int[] count = new int[26];

        for (char ch : str.toCharArray()) {
            count[ch - 'a']++;
        }

        for (int idx = 0; idx < 26; ++idx) {
            if (count[idx] < freq[idx]) {
                return false;
            }
        }

        return true;
    }
}

/**
str: l -> 1, e -> 3, t -> 1, c -> 1, o -> 1

l -> 1, o -> 2, e -> 1

 */