class Solution 
{
    public int[] leftRightDifference(int[] nums) 
    {
        int p[] = new int[nums.length];
        int q[] = new int[nums.length];

        for(int i=1;i<nums.length;i++)
            p[i]=nums[i-1]+p[i-1];

        for(int i=nums.length-1-1;i>=0;i--)
            q[i]=nums[i+1]+q[i+1];
        
        for(int i=0;i<p.length;i++)
            p[i]=Math.abs(p[i]-q[i]);

        return p;
    }
}