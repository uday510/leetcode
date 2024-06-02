class Solution {
    public void reverseString(char[] s) {
        int leftIdx = 0;
        int rightIdx = s.length - 1;
        
        while (rightIdx > leftIdx) {
            swap(leftIdx++, rightIdx--, s);
        }
    }
    public void swap(int leftIdx, int rightIdx, char[] s) {
        char temp = s[rightIdx];
        s[rightIdx] = s[leftIdx];
        s[leftIdx] = temp;
    }
}