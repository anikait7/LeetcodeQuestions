class Solution 
{
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) 
    {
        List<Integer> gap = new ArrayList<>();
        int len = startTime.length;
        int max=0;

        int temp=0;
        for(int i=0;i<len;i++)
        {
            gap.add(startTime[i]-temp);
            temp=endTime[i];
        }

        gap.add(eventTime-temp);
        for(int i=0;i<len;i++)
            max=Math.max(max,gap.get(i)+gap.get(i+1));

        int right_space[] = new int[len];
        int max_space=0;
        for(int i=len-1;i>=0;i--)
        {
            right_space[i]=max_space;
            max_space = Math.max(max_space,gap.get(i+1));
        }


        int left_gap=0;
        int prev=0;
        for(int i=0;i<len;i++)
        {
            int size = endTime[i]-startTime[i];

            if(i-1>=0)
                left_gap=Math.max(left_gap,gap.get(i-1));

            if(Math.max(right_space[i],left_gap)>=size)
            {
                if(i!=len-1)
                    max=Math.max(max,startTime[i+1]-prev);
                else
                    max=Math.max(max,eventTime-prev);                
            }
            prev=endTime[i];
        }

        return max;
    }
}