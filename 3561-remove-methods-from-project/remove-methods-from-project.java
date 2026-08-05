class Solution 
{
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) 
    {
        boolean arr[] = new boolean[n];
        int count=0;

        List<List<Integer>> list = new ArrayList<>();

        for(int i=0;i<n;i++)
            list.add(i, new ArrayList<>());

        for(int i=0;i<invocations.length;i++)
            list.get(invocations[i][0]).add(invocations[i][1]);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(k);
        arr[k]=true;

        while(!queue.isEmpty())
        {
            int x = queue.poll();
            count++;

            for(int i : list.get(x))
            {
                if(!arr[i])
                {
                    queue.add(i);
                    arr[i]=true;
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        boolean flag=true;
        
        for(int i=0;i<invocations.length && flag;i++)
        {
            int x = invocations[i][0];
            int y = invocations[i][1];

            //if a non suspicious is calling suspicious you cannot remove anything
            if(!arr[x] && arr[y])
            {
                for(int j=0;j<n;j++)
                    ans.add(j);

                return ans;
            }
        }

        //only keep not suspicious
        for(int i=0;i<n;i++)
            if(!arr[i])
                ans.add(i);

        return ans;
    }
}