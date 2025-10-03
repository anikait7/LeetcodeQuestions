class Solution 
{
    public int peopleAwareOfSecret(int n, int delay, int forget) 
    {
        long dp[] = new long[n+1];
        dp[1]=1;
        long c=0;

        for(int i=1;i<=n;i++)
        {
            for(int j=delay;j<forget;j++)
            {
                if(i+j<=n)
                    dp[i+j]=(dp[i+j]+dp[i])%1000000007;
            }
        }

        for(int i=n-forget+1;i<=n;i++)
            c=(c+dp[i])%1000000007;
        
        return (int)c;
    }
}