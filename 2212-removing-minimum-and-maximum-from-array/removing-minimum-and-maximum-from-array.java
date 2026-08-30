class Solution 
{
    public int minimumDeletions(int[] nums) 
    {
        int min = nums[0];  int min_idx = 0;
        int max = nums[0];  int max_idx=0;

        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]<min)
            {
                min=nums[i];
                min_idx=i;
            }

            if(nums[i]>max)
            {
                max=nums[i];
                max_idx=i;
            }
        }

        int n = nums.length;
        
        //deleting only from left
        int x = Math.max(max_idx,min_idx)+1;

        //deleting only from right
        x = Math.min(x,n-Math.min(max_idx,min_idx));

        //deleting from both extremes
        return Math.min(x,n-Math.max(max_idx,min_idx)+Math.min(max_idx,min_idx)+1);

    }
}