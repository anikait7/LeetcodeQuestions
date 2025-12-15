class Solution 
{
    public long getDescentPeriods(int[] prices) 
    {
        long sum=0;
        int c=1;

        for(int i=1;i<prices.length;i++)
        {
            if(prices[i-1]-prices[i]==1)
                c++;
            else
            {
                sum+=c*(c+1L)/2;
                c=1;
            }
        }

        return sum+c*(c+1L)/2;
    }
}