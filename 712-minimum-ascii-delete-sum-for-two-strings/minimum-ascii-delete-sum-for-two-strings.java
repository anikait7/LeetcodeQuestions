class Solution 
{
    int dp[][];

    public int recursive(int x, String s1, int y, String s2)
    {
        if(x==s1.length())
        {
            int sum=0;
            for(int i=y;i<s2.length();i++)
                sum+=(int)s2.charAt(i);

            return sum;
        }
        else
        if(y==s2.length())
        {
            int sum=0;
            for(int i=x;i<s1.length();i++)
                sum+=(int)s1.charAt(i);

            return sum;
        }
        else
        {
            if(dp[x][y]!=-1)
                return dp[x][y];

            if(s1.charAt(x)==s2.charAt(y))
                return dp[x][y] = recursive(x+1,s1,y+1,s2);

            int a = (int)s1.charAt(x)+recursive(x+1,s1,y,s2);
            int b = (int)s2.charAt(y)+recursive(x,s1,y+1,s2);

            return dp[x][y]=Math.min(a,b);
        }
    }

    public int minimumDeleteSum(String s1, String s2) 
    {
        dp = new int[s1.length()+1][s2.length()+1];

        for(int i=0;i<dp.length;i++)
            Arrays.fill(dp[i],-1);

        return recursive(0,s1,0,s2);   
    }
}