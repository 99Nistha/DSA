class Solution{
    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        int[][] t= new int[N+1][sum+1];
        for(int[] a: t){
            Arrays.fill(a, -1);
        }
        return (knapsack(0, arr, sum, t)==1)?true:false;
    }
    static int knapsack(int i, int arr[], int sum, int[][] t){
        if(sum==0) return 1;
        if(i>=arr.length) return 0;
        if(t[i][sum]!=-1) return t[i][sum];
        if(sum>=arr[i]){
            //its eligible
            //pick or notpick
            return t[i][sum]= (knapsack(i+1, arr, sum-arr[i], t) | knapsack(i+1, arr, sum, t));
        }else{
            return t[i][sum]= knapsack(i+1, arr, sum, t);
        }
    }
}
