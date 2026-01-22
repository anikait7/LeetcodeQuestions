class Solution 
{
    public boolean check(List<Integer> list)
    {
        for(int i=0;i<list.size()-1;i++)
            if(list.get(i)>list.get(i+1))
                return false;

        return true;
    }
    
    public int minimumPairRemoval(int[] nums) 
    {
        List<Integer> list = new ArrayList<>();
        int count=0;

        if(nums.length==1)
            return 0;

        for(int i=0;i<nums.length;i++)
            list.add(nums[i]);
        
        while(!check(list))
        {
            int min=list.get(0)+list.get(1);
            int pos=0;
            count++;

            for(int i=1;i<list.size()-1;i++)
            {
                if(list.get(i)+list.get(i+1)<min)
                {
                    min=list.get(i)+list.get(i+1);
                    pos=i;
                }
            }

            int x=list.remove(pos)+list.remove(pos);
            list.add(pos,x);
        }

        return count;
    }
}