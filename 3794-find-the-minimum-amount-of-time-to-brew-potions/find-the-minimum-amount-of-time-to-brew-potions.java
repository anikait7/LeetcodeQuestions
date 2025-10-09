class Solution 
{
    public long minTime(int[] wizard, int[] portions) 
    {
        int n = wizard.length;       int m = portions.length;

        long dp[] = new long[n];        

        for(int i=0;i<m;i++)
        {
            long curr=0;

            for(int j=0;j<n;j++)
                curr=Math.max(curr,dp[j])+wizard[j]*portions[i];

            dp[n-1]=curr;
            for(int j=n-2;j>=0;j--)
            {
                dp[j]=dp[j+1]-wizard[j+1]*portions[i];
            }            
        }

        return dp[n-1];
    }
}