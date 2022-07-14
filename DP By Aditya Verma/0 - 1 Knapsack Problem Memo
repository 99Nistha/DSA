class Solution 
{ 
    static int[][] t= new int[1001][1001];
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         for(int i=0;i<t.length; i++){
            for(int j=0;j<t[0].length; j++){
                t[i][j]=-1;
            }
         }
         return knap(W, wt, val, n);
    }
    public static int knap(int W, int wt[], int val[], int n){
        if(W==0 || n==0) return 0;
         if(t[W][n]!=-1) return t[W][n];
         if(wt[n-1]<=W){
             return t[W][n]= Math.max(val[n-1]+knap(W-wt[n-1], wt, val, n-1),
             knap(W, wt, val, n-1));
         }else{
             return t[W][n]= knap(W, wt, val, n-1);
         }
    }
}
