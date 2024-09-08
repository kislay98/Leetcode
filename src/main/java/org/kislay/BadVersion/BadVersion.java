package org.kislay.BadVersion;

class BadVersion {

    boolean isBadVersion(int version) {
        return version >= 5;
    }

    public int firstBadVersion(int n) {
        int start = 1;
        if (isBadVersion(start)) {
            return start;
        }
        while (n - start != 1) {
            int mid = start + (n-start)/2;
            if (isBadVersion(mid)) {
                n = mid;
            } else {
                start = mid;
            }
        }
        return n;
    }
}
