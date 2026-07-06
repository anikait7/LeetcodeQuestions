class Solution 
{
    public int removeCoveredIntervals(int[][] intervals) 
    {
        Arrays.sort(intervals,(a,b) -> a[0]!=b[0]? a[0]-b[0] : b[1]-a[1]);
        int count=1;

        int start=intervals[0][0];
        int end=intervals[0][1];

        for(int i=1;i<intervals.length;i++)
        {
            if(start<=intervals[i][0] && end>=intervals[i][1])
                continue;
            else
            {
                count++;
                start=intervals[i][0];
                end=intervals[i][1];
            }
        }

        return count;
    }
}