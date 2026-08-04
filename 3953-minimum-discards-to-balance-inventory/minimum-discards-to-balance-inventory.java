class Solution
{
    public int minArrivalsToDiscard(int[] arrivals, int w, int m) 
    {
        int discard=0;
        Set<Integer> set = new HashSet<>();

        int freq[] = new int[100001];

        for(int i=0;i<w;i++)
        {
            int x = arrivals[i];
            if(freq[x]<m)
                freq[x]++;
            else
            {
                discard++;
                set.add(i);
            }
        }

        int start=0;

        for(int i=w;i<arrivals.length;i++)
        {
            int x = arrivals[start];

            if(!set.contains(start))
                freq[x]--;

            start++;

            x = arrivals[i];
            if(freq[x]<m)
                freq[x]++;
            else
            {
                discard++;
                set.add(i);
            }
        }

        return discard;
    }
}

/* discard=11
7,3,9,5,2,6,10,1,4
*/