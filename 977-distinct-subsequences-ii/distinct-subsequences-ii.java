class Solution 
{
    int last_visited[] = new int[26];
    long dp[];

    public int distinctSubseqII(String s) 
    {
        dp = new long[s.length()+1];
        Arrays.fill(last_visited,-1);

        int mod = 1000000007;
        dp[0]=1;
        long prev=1;

        for(int i=0;i<s.length();i++)
        {
            int ch = s.charAt(i)-'a';

            prev=dp[i]*2;
            long temp=0;

            if(last_visited[ch]!=-1)
                temp=dp[last_visited[ch]];

            last_visited[ch]=i;

            prev=(prev-temp+mod)%mod;
            dp[i+1]=prev;
        }

        return (int)((dp[s.length()]-1+mod)%mod);
    }
}