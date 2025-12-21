class Solution 
{
    public long minCost(String s, int[] cost) 
    {
        long min=0;     long sum=0;
        long arr[] = new long[26];

        for(int i=0;i<s.length();i++)
        {
            arr[s.charAt(i)-'a']+=cost[i];
            sum+=cost[i];
        }

        min=sum;

        for(int i=0;i<26;i++)
            min=Math.min(min,sum-arr[i]);

        return min;
    }
}