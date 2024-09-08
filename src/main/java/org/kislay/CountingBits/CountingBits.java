package org.kislay.CountingBits;

class CountingBits {

    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i == 0 || i == 1) {
                result[i] = i;
            } else {
                result[i] = result[i ^ Integer.highestOneBit(i)] + 1;
            }
        }
        return result;
    }

    private static void fn(int n) {

        System.out.println(n >> 1);

    }

    public static void main(String[] args) {
        CountingBits countingBits = new CountingBits();
        int[] ints = countingBits.countBits(10);
        fn(3);
        fn(6);
        fn(7);

    }

}
