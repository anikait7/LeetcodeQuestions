class Solution 
{
    public int maximumAmount(int[][] coins) 
    {
        int r = coins.length;
        int c = coins[0].length;
        int max = Integer.MIN_VALUE;

        int dp[][][] = new int[r][c][3];
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
        }

        dp[0][0][2]=coins[0][0];

        if(coins[0][0]<0)
            dp[0][0][1]=0;

        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                for(int k=0;k<3;k++)
                {
                    if(dp[i][j][k]==Integer.MIN_VALUE)
                        continue;

                    if(i+1<r)
                    {
                        dp[i+1][j][k] = Math.max(dp[i+1][j][k], dp[i][j][k]+coins[i+1][j]);

                        if(coins[i+1][j]<0 && k>0)
                            dp[i+1][j][k-1] = Math.max(dp[i+1][j][k-1], dp[i][j][k]);
                    }

                    if(j+1<c)
                    {
                        dp[i][j+1][k] = Math.max(dp[i][j+1][k], dp[i][j][k]+coins[i][j+1]);

                        if(coins[i][j+1]<0 && k>0)
                            dp[i][j+1][k-1] = Math.max(dp[i][j+1][k-1], dp[i][j][k]);
                    }
                }
            }
        }

        for(int i=0;i<3;i++)
            max=Math.max(max,dp[r-1][c-1][i]);

        return max;
    }
}