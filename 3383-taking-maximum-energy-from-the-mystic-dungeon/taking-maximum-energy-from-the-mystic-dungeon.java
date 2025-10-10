class Solution 
{
    public int maximumEnergy(int[] energy, int k) 
    {
        int max=Integer.MIN_VALUE;
        int n = energy.length;

        int dp[] = new int[n];
        for(int i=n-1;i>=0;i--)
        {
            if(i+k<n)
                dp[i]=energy[i]+dp[i+k];
            else
                dp[i]=energy[i];
        }

        for(int i : dp)
            max=Math.max(max,i);

        return max;
    }
}