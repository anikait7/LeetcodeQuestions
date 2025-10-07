class Solution 
{
    public int[] avoidFlood(int[] rains) 
    {
        int n = rains.length;
        int ans[] = new int[n];

        Map<Integer,Integer> map = new HashMap<>();     //if present in map it should be dried 
        TreeSet<Integer> zero = new TreeSet<>();

        for(int i=0;i<n;i++)
        {   
            if(rains[i]==0)
            {
                zero.add(i);
                ans[i]=1;
            }
            else
            if(!map.containsKey(rains[i]))
            {
                ans[i]=-1;
                map.put(rains[i],i);
            }
            else
            {
                int ind=map.get(rains[i]);
                Integer x = zero.higher(ind);
                if(x==null)
                    return new int[]{};
                
                ans[x]=rains[i];
                zero.remove(x);
                ans[i]=-1;
                map.put(rains[i],i);
            }
        }

        return ans;
    }
}