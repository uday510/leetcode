class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder stringBuilder = new StringBuilder();

        int index = 0;

        for (int i = 0; i < s.length(); ++i) {

            if (index < spaces.length) {
                if (spaces[index] == i) {
                    stringBuilder.append(" ");

                    index++;
                }
            }

            stringBuilder.append(s.charAt(i));
        }

        return stringBuilder.toString();
    }
}