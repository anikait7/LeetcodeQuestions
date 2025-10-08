class Solution 
{
    public int[] successfulPairs(int[] spells, int[] potions, long success) 
    {
        int n = spells.length;
        int ans[] = new int[n];
        Arrays.sort(potions);

        for(int i=0;i<n;i++)
        {
            long x = spells[i];
            int lb=0;   int ub=potions.length-1;
            while(lb<=ub)
            {
                int mid = (lb+ub)/2;
                if((long)(x*potions[mid])>=success)
                    ub=mid-1;
                else
                    lb=mid+1;
            }

            ans[i]=potions.length-lb;
        }

        return ans;
    }
}