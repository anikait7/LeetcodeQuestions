class Solution 
{
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) 
    {
        int min=Integer.MAX_VALUE;
        
        for(int i=0;i<landStartTime.length;i++)
        {
            for(int j=0;j<waterStartTime.length;j++)
            {
                int x = landStartTime[i]+landDuration[i];

                int y = Math.max(x,waterStartTime[j]);
                min=Math.min(min,y+waterDuration[j]);
            }
        }

        for(int i=0;i<waterStartTime.length;i++)
        {
            for(int j=0;j<landStartTime.length;j++)
            {
                int x = waterStartTime[i]+waterDuration[i];

                int y = Math.max(x,landStartTime[j]);
                min=Math.min(min,y+landDuration[j]);
            }
        }
        
        return min;
    }
}