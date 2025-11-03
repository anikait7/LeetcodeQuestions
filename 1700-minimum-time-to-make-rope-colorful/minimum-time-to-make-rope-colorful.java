class Solution 
{
    public int minCost(String colors, int[] neededTime) 
    {
        int n = colors.length();
        int sum=0;
        int max=0;

        char prev=' ';

        for(int i=0;i<n;i++)
        {
            char ch = colors.charAt(i);             

            if(prev!=ch)
            {
                prev=ch;
                max=neededTime[i];
            }
            else
            {
                sum+=max;
                for(int j=i;j<n && colors.charAt(j)==prev;j++)
                {
                    i=j;
                    sum+=neededTime[j];
                    max=Math.max(max,neededTime[j]);
                }

                sum-=max;
            }
        }

        return sum;
    }
}