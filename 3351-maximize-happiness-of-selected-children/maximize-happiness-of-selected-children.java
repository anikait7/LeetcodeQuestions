class Solution 
{
    public long maximumHappinessSum(int[] happiness, int k) 
    {
        long sum=0;   int n = happiness.length;
        int c=0;

        Arrays.sort(happiness);

        for(int i=1;i<=k;i++)
        {
            int max = Math.max(0,happiness[n-i]-c++);
            sum+=max;
        }

        return sum;
    }
}