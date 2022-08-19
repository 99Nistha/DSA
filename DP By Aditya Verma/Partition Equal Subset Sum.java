class Solution{
    static int equalPartition(int N, int arr[])
    {
        // code here
        int sum=0;
        for(int i=0;i< arr.length; i++){
            sum+=arr[i];
        }
        if(sum%2!=0) return 0;
        int size= arr.length;
        int[][] t= new int[size+1][sum+1];
        for(int[] a: t){
            Arrays.fill(a, -1);
        }
        return subsetSum(0, arr, sum/2, t);
    }
    static int subsetSum(int i, int arr[], int sum, int[][] t){
        if(sum==0) return 1;
        if(i>=arr.length) return 0;
        if(t[i][sum]!=-1) return t[i][sum];
        if(sum>=arr[i]){
            //its eligible
            //pick or notpick
            return t[i][sum]= (subsetSum(i+1, arr, sum-arr[i], t) | subsetSum(i+1, arr, sum, t));
        }else{
            return t[i][sum]= subsetSum(i+1, arr, sum, t);
        }
    }
    
}
