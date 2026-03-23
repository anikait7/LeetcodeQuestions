class Solution 
{
    long dp[][][];
    int r;  int c;

    public void recursive(int x, int y, int grid[][], long product_neg, long product_pos)
    {
        if(x==r || y==c)
            return ;

        long pro1 = product_neg*grid[x][y];
        long pro2 = product_pos*grid[x][y];

        long max = Math.max(pro1,pro2);
        long min = Math.min(pro1,pro2);

       if(min>=dp[0][x][y] && max<=dp[1][x][y])
            return ;

        dp[0][x][y]=Math.min(dp[0][x][y], min);
        dp[1][x][y]=Math.max(dp[1][x][y], max);

        recursive(x+1,y,grid,dp[0][x][y],dp[1][x][y]);
        recursive(x,y+1,grid,dp[0][x][y],dp[1][x][y]); 
    }

    public int maxProductPath(int[][] grid) 
    {
        r = grid.length;      c = grid[0].length;

        dp = new long[2][r][c];
        //0th for lowest  1st for highest

        for(int i=0;i<r;i++)
        {
            Arrays.fill(dp[0][i], Long.MAX_VALUE);
            Arrays.fill(dp[1][i], Long.MIN_VALUE);
        }

        recursive(0,0,grid,1L,1L);

        return (int)(Math.max(-1,dp[1][r-1][c-1])%1000000007);
    }
}