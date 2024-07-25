class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = findPeak(mountainArr);

        int s = bs(mountainArr, 0, peak, target, 1);
        if (mountainArr.get(s) == target) {
            return s;
        }

        int e = bs(mountainArr, peak+1, mountainArr.length() - 1, target, -1);
        if (mountainArr.get(e) == target) {
            return e;
        }

        return -1;
    }

    public int bs(MountainArray mArr, int left, int right, int target, int sign) {
        target *= sign;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (mArr.get(mid)*sign < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int findPeak(MountainArray mArr) {
        int left = 0;
        int right = mArr.length() - 1;

        while (left < right) {
            int mid = (left + right) >> 1;

            if (mArr.get(mid) < mArr.get(mid + 1)) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}