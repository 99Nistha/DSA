Here is the Recursive solution which will give us time out but will help us understand the flow

Recursive

class Solution {
    int[][] dir= {{1,0}, {-1,0}, {0,1}, {0,-1}};
    int mod=1000000007;
	
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
		// just calling the fun recursively
        return rec(m, n, maxMove, startRow, startColumn);
    }
    
    public int rec(int m, int n, int move, int i, int j){
		// This is the base case here is we have reached out of the grid that mean we have found a path so return 1
        if(i<0 || j<0 || i>=m ||j>=n) return 1;
		// here move=0 means the we are still inside the grid and have no more moves so no possible path, return 0
        if(move==0) return 0;
        int ans=0;
        for(int[] d: dir){
			// move to all 4 directions and keed on adding the values in ann
            ans= (ans+ rec(m,n,move-1, i+d[0], j+d[1]))%mod;
        }// return ans
        return ans;
    }
}
This will give us timeout error bcz we are calling the rec funtion a lot of times, so the best way to store the calls which already happened is to use Memorisation (DP), here we will be using 3d Array, to store the data based on i, j, moves

3D DP Memorisation

class Solution {
    int[][] dir= {{1,0}, {-1,0}, {0,1}, {0,-1}};
    int mod=1000000007;
	
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
		// only diff here is to use dp to store the call which already got us some output
        int[][][] dp= new int[m+1][n+1][maxMove+1];
        for(int[][] d1: dp){
			// initalizing the entire 3d array with -1
            for(int[] d2: d1) Arrays.fill(d2, -1);
        }
		//rec call
        return rec(m, n, maxMove, startRow, startColumn, dp);
    }
    
    public int rec(int m, int n, int move, int i, int j, int[][][] dp){
        if(i<0 || j<0 || i>=m ||j>=n) return 1;
        if(move==0) return 0;
		//here just check if its not -1, that mean some value had been assigned to it, so simply return that
        if(dp[i][j][move]!=-1) return dp[i][j][move];
        int ans=0;
        for(int[] d: dir){
            ans= (ans+ rec(m,n,move-1, i+d[0], j+d[1], dp))%mod;
        }
		//just make sure to store our ans inside our dp, so that we can use it afterwards, when same fun is getting called
        return dp[i][j][move]= ans;
    }
}
Time Compexity: O(m.n.maxMove);
Space Compexity: O(m.n.maxMove);
