class Solution 
{
    public int minimumDifference(int[] nums, int k) 
    {
        if(k==1)
            return 0;

        Arrays.sort(nums);

        int n = nums.length;
        int diff=nums[n-1];

        for(int i=k-1;i<nums.length;i++)
            diff=Math.min(diff,nums[i]-nums[i-k+1]);

        return diff;
    }
}