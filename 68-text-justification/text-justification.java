class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        var ans = new ArrayList<String>();
        var curr = new ArrayList<String>();
        int len = 0;

        for (String word : words) {
            if (word.length() + curr.size() + len > maxWidth) {
                int totalSpace = maxWidth - len;
                int gaps = curr.size() - 1;
                if (gaps == 0) {
                    ans.add(curr.getFirst() + " ".repeat(totalSpace));
                } else {
                    int spaceBtw = totalSpace / gaps;
                    int extraSpace = totalSpace % gaps;

                    var line = new StringBuilder();
                    for (int i = 0; i < curr.size(); ++i) {
                        line.append(curr.get(i));

                        if (i < gaps) {
                            line.append(" ".repeat(spaceBtw));
                            if (i < extraSpace) {
                                line.append(" ");
                            }
                        }
                    }
                    ans.add(line.toString());
                }
                curr.clear();
                len = 0;
            }
            curr.add(word);
            len += word.length();
        }

        var last = new StringBuilder(String.join(" ", curr));

        while (last.length() < maxWidth) {
            last.append(" ");
        }

        ans.add(last.toString());
        return ans;
    }
}