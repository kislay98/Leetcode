package org.kislay.ClimbStairs;

public class ClimbStairs {

    public int climbStairs(int n) {
        if (n==1) {
            return 1;
        }
        if (n==2) {
            return 2;
        }
        int currMinusTwo = 1;
        int currMinusOne = 2;
        for (int i = 3; i<=n; i++) {
            int temp = currMinusOne;
            currMinusOne = currMinusTwo + currMinusOne;
            currMinusTwo = temp;
        }
        return currMinusTwo;
    }
}
