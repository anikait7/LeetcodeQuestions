class Solution 
{
    public int absDifference(int[] nums, int k) 
    {
        int n = nums.length;
        Arrays.sort(nums);
        int sum=0;

        for(int i=0;i<Math.min(n,k);i++)
            sum-=nums[i];

        for(int i=n-1;i>=Math.max(0,n-k);i--)
            sum+=nums[i];

        return sum;
    }
}