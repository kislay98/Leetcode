package org.kislay.CoinChange;

class CoinChange {

    public int coinChange(int[] coins, int amount) {

        int[] noOfCoinsRequired = new int[amount+1];
        noOfCoinsRequired[0] = 0;
        for (int i = 1; i <= amount; i++) {
            noOfCoinsRequired[i] = coinsRequiredAtIth(coins, noOfCoinsRequired, i);
        }
        return noOfCoinsRequired[amount];
    }

    private int coinsRequiredAtIth(int[] coins, int[] noOfCoinsRequired, int currIndx) {
        int minCoinsReq = Integer.MAX_VALUE;
        for (int coin: coins) {
            if (currIndx >= coin) {
                int noOfCoinsRequiredAtOffset = noOfCoinsRequired[currIndx-coin];
                if (noOfCoinsRequiredAtOffset == -1) {
                    continue;
                }
                minCoinsReq = Math.min(noOfCoinsRequiredAtOffset + 1, minCoinsReq);
            }
        }
        return minCoinsReq == Integer.MAX_VALUE ? -1: minCoinsReq;
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange(new int[]{1,2,5}, 11));
    }

}
