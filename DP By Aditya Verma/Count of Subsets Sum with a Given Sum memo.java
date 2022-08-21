class Solution{
    int mod=(int)1e9+7;
	public int perfectSum(int nums[],int n, int target) 
	{ 
	    // Your code goes here
	    if(nums==null || nums.length==0) return 0;
	    int[][] t= new int[n+1][target+1];
        for(int i=0;i<n;i++){
            t[i][0]=1;
        }
        for(int index=1;index<=n;index++){
            for(int sum=0;sum<=target; sum++){
                if(nums[index-1]<=sum){
                    t[index][sum]= (t[index-1][sum-nums[index-1]]+ t[index-1][sum])%mod;
                }else t[index][sum]= t[index-1][sum]%mod;
            }
        }
        return t[n][target]%mod;
	} 
}
