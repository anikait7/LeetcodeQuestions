class Solution 
{
    public int minimumBoxes(int[] apple, int[] capacity) 
    {
        int c=0;
        for(int i : apple)
            c+=i;

        Arrays.sort(capacity);
        int count=0;
        for(int i=capacity.length-1;i>=0 && c>0;i--)
        {
            count++;
            c-=capacity[i];
        }


        return count;
    }
}