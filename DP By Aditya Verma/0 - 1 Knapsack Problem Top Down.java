class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        int[][] t= new int[n+1][W+1];
        for(int i=0; i<= n; i++){
            for(int j=0; j<=W; j++){
                if(i==0 || j==0){
                    t[i][j]=0;
                    continue;
                }
                if(wt[i-1]<=j){
                    t[i][j]= Math.max((val[i-1]+t[i-1][j-wt[i-1]]), 
                                       t[i-1][j]);
                }else t[i][j]= t[i-1][j];
            }
        }
        return t[n][W];
    }
}
