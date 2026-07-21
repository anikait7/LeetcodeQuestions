class Solution 
{          
    int MOD = 1000000007;

    public int zigZagArrays(int n, int l, int r) 
    {
        int end = r-l+1;
        int dp[][][] = new int[n+1][end+1][2];

        //base case 
        for(int i=1;i<=end;i++)
            dp[n][i][0] = dp[n][i][1] = 1;
        

        for(int i=n-1;i>=0;i--) //index loop
        {
            long cfi[] = new long[end+1];
            long cfd[] = new long[end+1];

            for(int val=1;val<=end;val++)
            {
                cfd[val] = (cfd[val-1] + dp[i+1][val][0])%MOD;
                cfi[val] = (cfi[val-1] + dp[i+1][val][1])%MOD;
            }

            for(int j=1;j<=end;j++) //value loop
            {
                dp[i][j][1]= (int)(cfd[end] - cfd[j]+MOD)%MOD;
                dp[i][j][0]= (int)(cfi[j-1] - cfi[0]+MOD)%MOD;
            }
        }

        //final answer is stored here
        long ans=0;
        for(int i=1;i<=end;i++)
        {
            ans = (ans+dp[1][i][1])%MOD;
            ans = (ans+dp[1][i][0])%MOD;
        }

        return (int)(ans);
    }
}