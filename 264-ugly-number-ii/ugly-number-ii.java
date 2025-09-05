class Solution {
    public int nthUglyNumber(int n) {
        int[] uglies = new int[n];
        uglies[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;

        for (int i = 1; i < n; i++) {
            int next2 = uglies[i2] * 2;
            int next3 = uglies[i3] * 3;
            int next5 = uglies[i5] * 5;

            int nextUgly = Math.min(next2, Math.min(next3, next5));
            uglies[i] = nextUgly;

            if (nextUgly == next2) i2++;
            if (nextUgly == next3) i3++;
            if (nextUgly == next5) i5++;

        }

        return uglies[n - 1];
    }
}

/**
n = 10

uglies = [1, 2, 3, 4, 5]

i2 = 2, i3 = 1, i5 = 1

min(8, 9, 25)

 */