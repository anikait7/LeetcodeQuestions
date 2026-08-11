class Solution 
{
    public int missingInteger(int[] nums) 
    {
        int sum=nums[0];
        Set<Integer> set = new HashSet<>();
        set.add(sum);
        boolean flag=true;

        for(int i=1;i<nums.length;i++)
        {
            set.add(nums[i]);

            if(flag && nums[i]==nums[i-1]+1)
                sum+=nums[i];
            else
            {
                flag=false;
            }
        }

        while(set.contains(sum))
            sum++;

        return sum;
    }
}