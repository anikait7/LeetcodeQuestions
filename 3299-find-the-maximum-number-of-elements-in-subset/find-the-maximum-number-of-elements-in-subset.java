class Solution 
{
    public int maximumLength(int[] nums) 
    {
        Set<Integer> set = new HashSet<>();
        Map<Integer,Integer> map = new HashMap<>();

        int max=0;

        //frequency counting
        for(int i : nums)
        {
            if(i==1)
            {
                max++;
                continue;
            }

            set.add(i);
            map.put(i, map.getOrDefault(i,0)+1);
        }

        if(max!=0 && max%2==0)
            max--;

        for(int num : set)
        {
            int count=1;
            long val=num*num*1L;

            if(map.get(num)<2)
                continue;

            while(val<Integer.MAX_VALUE)
            {
                if(!set.contains((int)val))
                    break;

                count+=2;
                if(map.get((int)val)==1)
                    break;
                
                val=val*val;
            }
            
            max=Math.max(max,count);
        }

        return Math.max(1,max);
    }
}