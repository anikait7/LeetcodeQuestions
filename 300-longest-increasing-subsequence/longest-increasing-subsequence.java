class Solution 
{
    public int lengthOfLIS(int[] nums) 
    {
        int len=nums.length;
        int lis[] = new int[len];
        Arrays.fill(lis,1);
        int max=1;

        for(int i=1;i<nums.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[j]<nums[i] && lis[i]<=lis[j])
                {
                    lis[i]=lis[j]+1;
                    max=Math.max(max,lis[i]);
                }
            }
        }

        return max;
    }
}