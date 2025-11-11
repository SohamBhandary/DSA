class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] extendedNums = new int[n + 2];
        extendedNums[0] = 1;
        extendedNums[n + 1] = 1;       
        for (int i = 1; i <= n; i++) {
            extendedNums[i] = nums[i - 1];
        }
        int[][] dp = new int[n + 2][n + 2];       
        for (int length = 1; length <= n; length++) { 
            for (int left = 1; left <= n - length + 1; left++) {
                int right = left + length - 1;            
              for (int i = left; i <= right; i++) {
                    int coins = extendedNums[left - 1] * extendedNums[i] * extendedNums[right + 1];
                    coins += dp[left][i - 1] + dp[i + 1][right];
                    dp[left][right] = Math.max(dp[left][right], coins);
                }
            }
        }      
        return dp[1][n];
    }
}