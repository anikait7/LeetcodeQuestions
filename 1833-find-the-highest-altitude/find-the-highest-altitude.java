class Solution 
{
    public int largestAltitude(int[] gain) 
    {
        int max=0;
        int alt=0;

        for(int i : gain)
        {
            alt+=i;
            max=Math.max(max,alt);
        }

        return max;
    }
}