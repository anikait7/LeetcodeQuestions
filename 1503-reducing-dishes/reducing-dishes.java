class Solution 
{
    public int maxSatisfaction(int[] satisfaction) 
    {
        Arrays.sort(satisfaction);
        int suffix[] = new int[satisfaction.length+1];

        for(int i=satisfaction.length-1;i>=0;i--)
            suffix[i]=suffix[i+1]+satisfaction[i];

        int max=0;
        int sum=0;

        for(int i=satisfaction.length-1;i>=0;i--)
        {
            sum+=satisfaction[i]+suffix[i+1];
            max=Math.max(max,sum);
        }

        //2 3 4 -> 9 7 4 0

        return max;
    }
}