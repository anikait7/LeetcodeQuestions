class Solution 
{
    public int[] processQueries(int c, int[][] connections, int[][] queries) 
    {
        int union[] = new int[c+1];
        int k=0;
        boolean state[] = new boolean[c+1];
        Arrays.fill(state,true);
        
        int count=0;        
        for(int i=0;i<queries.length;i++)
            if(queries[i][0]==1)
                count++;

        int ans[] = new int[count];
        int ptr=0;

        Map<Integer,List<Integer>> map1 = new HashMap<>();
        
        for(int i=1;i<=c;i++)
            map1.put(i,new ArrayList<>());

        for(int i=0;i<connections.length;i++)
        {
            int x=connections[i][0];
            int y=connections[i][1];

            map1.get(x).add(y);
            map1.get(y).add(x);
        }


        boolean visited[] = new boolean[c+1];
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=1;i<=c;i++)
        {
            if(!visited[i])
            {            
                k++;
                queue.add(i);
                visited[i]=true;
                union[i]=k;

                while(!queue.isEmpty())
                {
                    int x = queue.poll();
                    for(int j=0;j<map1.get(x).size();j++)
                    {
                        if(!visited[map1.get(x).get(j)])
                        {
                            visited[map1.get(x).get(j)]=true;
                            queue.add(map1.get(x).get(j));
                            union[map1.get(x).get(j)]=k;
                        }
                    }
                }
            }
        }

        Map<Integer,PriorityQueue<Integer>> map = new HashMap<>();
        for(int i=1;i<=c;i++)
            map.put(i, new PriorityQueue<>());

        for(int i=1;i<union.length;i++)
        {
            map.get(union[i]).add(i);
        }
        
        
        for(int i=0;i<queries.length;i++)
        {
            int station = queries[i][1];
            
            if(queries[i][0]==2)
                state[station]=false;
            else
            {
                if(state[station])
                    ans[ptr++]=station;
                else
                {
                    PriorityQueue<Integer> pq = map.get(union[station]);
                    while(!pq.isEmpty() && !state[pq.peek()])
                        pq.poll();

                    if(pq.isEmpty())
                        ans[ptr++]=-1;
                    else
                        ans[ptr++]=pq.peek();

                }
            }
            
        }

        return ans;
    }
}