class Solution 
{
    public int maxProfit(int[] prices) 
    {
       int maxProfit=0;
       int minPrice=prices[0];
        
       for(int i=1;i<prices.length;i++)
       {
            if(prices[i]<minPrice)
                minPrice=prices[i];
            else
            if(prices[i]-minPrice>maxProfit)
                maxProfit=prices[i]-minPrice;       
       }
        return maxProfit;
    }
}

/**
class Solution 
{
    public int maxProfit(int[] prices) 
    {
        int i,j,profit=0;

        for(i=0;i<prices.length;i++)
        {
            for(j=i+1;j<prices.length;j++)
            {
                if(prices[j]-prices[i]<=0)
                    break;

                if(prices[j]-prices[i]>profit)
                    profit=prices[j]-prices[i];
            }
        }
        return profit;
    }
}
*/