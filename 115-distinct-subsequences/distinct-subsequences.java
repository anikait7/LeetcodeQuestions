class Solution 
{   
    int dp[][];       // si = st index   ti = target index
    public int recursive(String st, String target, int si, int ti)
    {
        if(ti==target.length())
            return 1;

        if(si==st.length())
            return 0;

        if(dp[si][ti]!=-1)
            return dp[si][ti];

        //ignore the current character
        int x = recursive(st,target,si+1,ti);

        int y = 0;

        if(st.charAt(si)==target.charAt(ti))
            y = recursive(st,target,si+1,ti+1);

        return dp[si][ti]=x+y;
    }

    public int numDistinct(String s, String t) 
    {
        dp = new int[s.length()][t.length()];
        for(int i=0;i<s.length();i++)
            Arrays.fill(dp[i], -1);
            
        return recursive(s,t,0,0);
    }
}