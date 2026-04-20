class Solution 
{
    public int maxDistance(int[] colors) 
    {
        // Map<Integer, int[]> map = new HashMap<>();

        // for(int i=0;i<colors.length;i++)
        // {
        //     if(map.containsKey(colors[i]))
        //         map.get(colors[i])[1]=i;
        //     else
        //         map.put(colors[i], new int[]{i,i});
        // }

        int dist=0;
        for(int i=0;i<colors.length;i++)
        {
            for(int j=i+1+dist;j<colors.length;j++)
                if(colors[i]!=colors[j])
                    dist=Math.max(dist,j-i);
        }

        return dist;
    }
}