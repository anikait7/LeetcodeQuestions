class Solution 
{
    long dp[][];
    int n;

    public long recursive(int values[], int i, int j)
    {
        if(dp[i][j]!=-1)
            return dp[i][j];

        if(j-i<2)
            return 0;
        
        long ans = Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++)
        {
            long val = recursive(values,i,k)+recursive(values,k,j)+values[i]*values[j]*values[k];
            ans=Math.min(ans,val);
        }

        return dp[i][j]=ans;
    }

    public int minScoreTriangulation(int[] values) 
    {
        n = values.length;
        dp = new long[n][n];

        for(int i=0;i<n;i++)
            Arrays.fill(dp[i],-1);

        return (int)recursive(values,0,n-1);
    }
}