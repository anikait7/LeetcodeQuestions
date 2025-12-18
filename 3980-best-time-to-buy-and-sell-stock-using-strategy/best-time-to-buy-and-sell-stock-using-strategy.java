class Solution 
{
    public long maxProfit(int[] prices, int[] strategy, int k) 
    {
        int n = prices.length;

        long pre_sum[] = new long[n+1];

        for(int i=0;i<n;i++)
            pre_sum[i+1]=pre_sum[i]+prices[i]*strategy[i];

        long sum = pre_sum[n];

        long window=0;        
        int left = 0;    int mid = k/2;    int right = k;

        for(int i=mid;i<right;i++)
            window+=prices[i];
        
        long temp = sum-pre_sum[k]+window;

        long max = Math.max(sum,temp);

        while(right<n)
        {
            window = window+prices[right++]-prices[mid++];
            temp=sum+window-(pre_sum[right]-pre_sum[++left]);
            max=Math.max(max,temp);
        }

        return max;
    }
}