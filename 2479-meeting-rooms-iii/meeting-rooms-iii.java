class Solution 
{
    public int mostBooked(int n, int[][] meetings) 
    {
        int freq[] = new int[n];
        Arrays.sort(meetings, (a,b)-> a[0]-b[0]);

        PriorityQueue<Integer> room = new PriorityQueue<>();

        for(int i=0;i<n;i++)
            room.add(i);

        PriorityQueue<long []> pq = new PriorityQueue<>(new Comparator<long []>()
        {
            public int compare(long x[], long y[])
            {
                if(x[1]!=y[1])
                    return Long.compare(x[1],y[1]);
                else
                    return Long.compare(x[0],y[0]);
            }
        });

        for(int i=0;i<meetings.length;i++)
        {
            while(!pq.isEmpty() && pq.peek()[1]<=meetings[i][0])
            {
                long temp[] = pq.poll();
                room.add((int)temp[0]);
            }

            if(!room.isEmpty())
            {
                int x=room.poll();
                freq[x]++;
                pq.add(new long[]{x,(long)meetings[i][1]});
            }
            else
            {
                int diff=meetings[i][1]-meetings[i][0];
                long temp[] = pq.poll();
                freq[(int)temp[0]]++;
                pq.add(new long[]{temp[0],temp[1]+diff});
            }
        }

        int max=freq[0];        int index=0;

        for(int i=1;i<n;i++)
        {
            if(freq[i]>max)
            {
                max=freq[i];
                index=i;
            }
        }

        return index;
    }
}