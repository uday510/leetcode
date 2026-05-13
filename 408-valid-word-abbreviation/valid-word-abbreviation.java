class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length()) {
            if (word.charAt(i) == abbr.charAt(j)) {
                i++;
                j++;
            } else if (abbr.charAt(j) - '0' > 0 && abbr.charAt(j) - '0' < 10){
                int tmp = 0;
                while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    tmp = tmp * 10 + (abbr.charAt(j) - '0');
                    j++;
                }
                i += tmp;
            } else {
                return false;
            }
        }

        return i == word.length() && j == abbr.length();
    }

}