class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        StringBuilder curr = new StringBuilder();

        int index = 0;
        int idx = 0;

        while (index < spaces.length) {

            if (idx == spaces[index]) {
                sb.append(curr.toString());
                sb.append(" ");
                curr = new StringBuilder();

                index++;    
            } 

            curr.append(s.charAt(idx));
            
            idx++;
        }

        curr.append(s.substring(idx, s.length()));

        sb.append(curr.toString());

        return sb.toString();
    }
}