class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount<1) return 0;
        int minDp[]= new int[amount+1];
        for(int i =1;i<=amount;i++){
          minDp[i]=Integer.MAX_VALUE;
        
        for(int coin:coins){
            if(coin<=i && minDp[i-coin]!=Integer.MAX_VALUE){
                minDp[i]=Math.min(minDp[i],1+minDp[i-coin]);
            }
        }
        }

       return minDp[amount]==Integer.MAX_VALUE?-1:minDp[amount];

        
    }
}