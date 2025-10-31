class Solution {
    public int lengthOfLIS(int[] nums) {

        int [] ans= new int[nums.length];

        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    if(ans[j]+1>ans[i]){
                        ans[i]=ans[j]+1;
                    }
                }
            }
        }
        int maxLIS = 0;
    for(int length : ans) {
    maxLIS = Math.max(maxLIS, length);
      }
    return maxLIS+1;
        
        
    }
}