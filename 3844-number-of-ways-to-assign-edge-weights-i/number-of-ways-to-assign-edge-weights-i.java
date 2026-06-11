class Solution 
{
    public int assignEdgeWeights(int[][] edges) 
    {
        List<List<Integer>> list = new ArrayList<>();

        for(int i=0;i<=edges.length+1;i++)        
            list.add(new ArrayList<>());
        

        for(int i=0;i<edges.length;i++)
        {
            int x=edges[i][0];
            int y=edges[i][1];
            list.get(x).add(y);
            list.get(y).add(x);
        }

        int depth=0;
        boolean visited[] = new boolean[edges.length+2];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1]=true;

        int size=1;
        while(!queue.isEmpty())
        {
            for(int i=0;i<size;i++)
            {
                int x=queue.poll();
                for(int j=0;j<list.get(x).size();j++)
                {
                    if(!visited[list.get(x).get(j)])
                    {
                        visited[list.get(x).get(j)]=true;
                        queue.add(list.get(x).get(j));
                    }
                }
            }

            size=queue.size();
            depth++;            
        }

        int ans=1;
        depth--;

        for(int i=1;i<depth;i++)
            ans=(ans*2)%1000000007;

        return ans;
    }
}