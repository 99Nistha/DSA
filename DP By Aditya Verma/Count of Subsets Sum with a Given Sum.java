class Solution{
    int toMod=(int)1e9+7;
	public int perfectSum(int nums[],int n, int target) 
	{ 
	    // Your code goes here
	    if(nums==null || nums.length==0) return 0;
        int val= knapsack(0, nums, target, 0);
        return val%toMod;
	} 
	public int knapsack(int index, int[] nums, int sum, int set){
        if(sum==0) return 1;
        if(index>=nums.length) return 0;
        if(nums[index]<=sum){
            return set+= knapsack(index+1, nums, sum-nums[index], set)+ 
                         knapsack(index+1, nums, sum, set);
        }
        else return knapsack(index+1, nums, sum, set);
    }
}
