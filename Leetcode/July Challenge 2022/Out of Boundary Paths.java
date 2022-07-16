class Solution {
    int[][] dir= {{1,0}, {-1,0}, {0,1}, {0,-1}};
    int mod=1000000007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp= new int[m+1][n+1][maxMove+1];
        for(int[][] d1: dp){
            for(int[] d2: d1) Arrays.fill(d2, -1);
        }
        return rec(m, n, maxMove, startRow, startColumn, dp);
    }
    
    public int rec(int m, int n, int move, int i, int j, int[][][] dp){
        if(i<0 || j<0 || i>=m ||j>=n) return 1;
        if(move==0) return 0;
        if(dp[i][j][move]!=-1) return dp[i][j][move];
        int ans=0;
        for(int[] d: dir){
            ans= (ans+ rec(m,n,move-1, i+d[0], j+d[1], dp))%mod;
        }
        return dp[i][j][move]= ans;
    }
}
