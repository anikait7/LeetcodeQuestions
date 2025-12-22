class Solution 
{
    public int minOperations(int[] nums) 
    {
        Set<Integer> set = new HashSet<>();
        Map<Integer,Integer> map = new HashMap<>();
        int pos=-1;

        for(int i=nums.length-1;i>=0;i--)
        {
            if(set.contains(nums[i]))
            {
                pos=i;
                break;
            }

            set.add(nums[i]);
        }

        if(pos==-1)
            return 0;
        else
            return (pos+3)/3;
    }
}