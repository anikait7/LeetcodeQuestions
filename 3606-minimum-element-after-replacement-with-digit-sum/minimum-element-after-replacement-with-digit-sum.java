class Solution 
{
    int sum(int n)
    {
        int s=0;
        while(n>0)
        {
            s=s+n%10;
            n/=10;
        }
        return s;
    }

    public int minElement(int[] nums) 
    {
        int h=sum(nums[0]);

        for(int i:nums)
            if(sum(i)<h)
                h=sum(i);
                
        return h;
    }
}