class Solution 
{
    public int firstUniqueFreq(int[] nums) 
    {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i : nums)
            map.put(i, map.getOrDefault(i,0)+1);

        Map<Integer,Integer> freq = new HashMap<>();
        
        for(Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            freq.put(entry.getValue(), freq.getOrDefault(entry.getValue(),0)+1);
        }

        for(int i : nums)
        {
            if(freq.get(map.get(i))==1)
                return i;
        }

        return -1;
    }
}