class Solution 
{
    public long maxAlternatingSum(int[] nums) 
    {
        long pro=0;

        for(int i=0;i<nums.length;i++)
            if(nums[i]<0)
                nums[i]=-nums[i];
        

        Arrays.sort(nums);

        int right=nums.length-1;
        int left=0;

        while(left<right)
        {
            pro+=nums[right]*nums[right--]-nums[left]*nums[left++];
        }

        if(left==right)
            pro+=nums[left]*nums[left];

        return pro;
    }
}