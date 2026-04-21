class Solution 
{
    int parent[];

    public int find(int xyz)
    {
        if(parent[xyz]==xyz)
            return xyz;

        return parent[xyz]=find(parent[xyz]);
    }

    public void do_union(int x, int y)
    {
        int X = find(x);
        int Y = find(y);

        if(X!=Y)
            parent[Y]=X;  
    }

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) 
    {
        int len = target.length;
        int count=0;
        parent = new int[len];

        for(int i=0;i<len;i++)
            parent[i]=i;

        for(int arr[] : allowedSwaps)
        {
            int x = arr[0];
            int y = arr[1];

            do_union(x,y);
        }

        Map<Integer,Map<Integer,Integer>> map = new HashMap<>();

        for(int i=0;i<len;i++)
        {
            int root = find(i);
            if(!map.containsKey(root))
                map.put(root, new HashMap<>());

            Map<Integer,Integer> freq = map.get(root);
            freq.put(source[i], freq.getOrDefault(source[i],0)+1);
            freq.put(target[i], freq.getOrDefault(target[i],0)-1);
        }

        for(Map.Entry<Integer,Map<Integer,Integer>> entry : map.entrySet())
        {
            Map<Integer,Integer> freq = entry.getValue();

            for(Map.Entry<Integer,Integer> entry1 : freq.entrySet())
                count+=Math.abs(entry1.getValue());
        }

        return count/2;
    }
}