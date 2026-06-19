class Solution {
    
  public int largestAltitude(int[] gains) {
    int alt = 0, mx = 0;

    for (int g : gains) {
        alt += g;
        mx = Math.max(mx, alt);
    }

    return mx;
  }

}
