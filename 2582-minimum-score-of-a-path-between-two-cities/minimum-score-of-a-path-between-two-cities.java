class Solution 
{
    public int minScore(int n, int[][] roads) 
    {
        List<Integer> map[] = new ArrayList[n+1];
        int min=Integer.MAX_VALUE;

        for(int i=1;i<=n;i++)
            map[i]=new ArrayList<>();

        for(int road[] : roads)
        {
            map[road[0]].add(road[1]);
            map[road[1]].add(road[0]);
        }

        boolean visited[] = new boolean[n+1];
        visited[n]=true;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(n);

        while(!queue.isEmpty())
        {
            int x = queue.poll();

            for(int i=0;i<map[x].size();i++)
            {
                if(!visited[map[x].get(i)])
                {
                    visited[map[x].get(i)]=true;
                    queue.add(map[x].get(i));
                }
            }
        }

        for(int road[] : roads)
        {
            if(visited[road[0]] && visited[road[1]])
                min=Math.min(min,road[2]);
        }
        
        return min;
    }
}