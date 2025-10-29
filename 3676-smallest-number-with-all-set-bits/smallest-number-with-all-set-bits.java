class Solution 
{
    public int smallestNumber(int n) 
    {
        int i,z;
        for(i=1; ;i++)
        {
            z=(int)Math.pow(2,i)-1;
            if(z>=n)
                return z;
        }
    }
}