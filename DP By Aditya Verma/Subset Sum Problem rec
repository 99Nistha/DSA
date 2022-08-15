class Solution{
    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        return knapsack(0, arr, sum);
    }
    static boolean knapsack(int i, int arr[], int sum){
        if(sum==0) return true;
        if(i>=arr.length) return false;
        if(sum>=arr[i]){
            //its eligible
            //pick or notpick
            return (knapsack(i+1, arr, sum-arr[i]) || knapsack(i+1, arr, sum));
        }else{
            return knapsack(i+1, arr, sum);
        }
    }
}
