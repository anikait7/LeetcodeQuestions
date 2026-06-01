class Solution 
{
    public int minimumCost(int[] cost) 
    {
        int count=0;    int c=1;
        Arrays.sort(cost);

        for(int i=cost.length-1;i>=0;i--)
        {
            if(c%3==0)
            {
                c++;
                continue;
            }

            count+=cost[i];
            c++;
        }

        return count;
    }
}
/*
2 2 5 6 7 9
*/