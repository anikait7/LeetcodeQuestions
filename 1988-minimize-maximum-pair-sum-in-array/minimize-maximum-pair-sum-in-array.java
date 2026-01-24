class Solution 
{
    public int minPairSum(int[] nums) 
    {
        int n = nums.length;
        Arrays.sort(nums);
        int max=nums[0];

        for(int i=0;i<nums.length/2;i++)
            max=Math.max(max,nums[i]+nums[n-1-i]);
        
        return max;
    }
}