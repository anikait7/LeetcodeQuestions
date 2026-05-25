class Solution 
{
    public int findMin(int[] nums) 
    {
        int n = nums.length;
        int lb=0;   int ub=n-1;

        while(lb<ub)
        {
            int mid = (lb+ub)/2;

            if(nums[mid]>nums[ub])
                lb=mid+1;
            else
                ub=mid;
        }

        return nums[lb];
    }
}