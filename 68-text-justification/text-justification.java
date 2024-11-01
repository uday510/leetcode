class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        var ans = new ArrayList<String>();
        var currWords = new ArrayList<String>();
        int currLen = 0;

        for (String word : words) {
            if (currWords.size() + currLen + word.length() > maxWidth) {
                int totalSpace = maxWidth - currLen;
                int gaps = currWords.size() - 1;
                if (gaps == 0) {
                    ans.add(currWords.getFirst() + " ".repeat(totalSpace));
                } else {
                    int spaceBtw = totalSpace / gaps;
                    int extraSpace = totalSpace % gaps;

                    StringBuilder line = new StringBuilder();
                    for (int i = 0; i < currWords.size(); ++i) {
                        String curr = currWords.get(i);
                        line.append(curr);
                        if (i < gaps) {
                            line.append(" ".repeat(spaceBtw));
                            if (i < extraSpace) {
                                line.append(" ");
                            }
                        }
                    }
                    ans.add(line.toString());
                }
                currWords.clear();
                currLen = 0;
                    
            } 
            currWords.add(word);
            currLen += word.length();
        }

        StringBuilder lastLine = new StringBuilder(String.join(" ", currWords));
        while (lastLine.length() < maxWidth) {
            lastLine.append(" ");
        }

        ans.add(lastLine.toString());
        return ans;
    }
}