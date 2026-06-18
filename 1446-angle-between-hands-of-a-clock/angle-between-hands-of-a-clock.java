class Solution {
    public double angleClock(int hr, int mins) {
        
        double minsAngle = mins * 6;
        double hrAngle = ((hr % 12) * 30) + (mins * 0.5);

        double diff = Math.abs(hrAngle - minsAngle);

        return Math.min(360 - diff, diff);
    }
}