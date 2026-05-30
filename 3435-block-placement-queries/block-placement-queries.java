class Solution 
{
    class Segment
    {
        int tree[];

        Segment(int n)
        {
            tree = new int[4*n];
        }

        void update(int node, int start, int end, int idx, int val)
        {
            if(start==end)
            {
                tree[node]=val;
                return ;
            }

            int mid = (start+end)/2;

            if(idx<=mid)
                update(2*node+1, start, mid, idx, val);
            else
                update(2*node+2, mid+1, end, idx, val);

            tree[node]=Math.max(tree[2*node+1],tree[2*node+2]);
        }

        int query(int node, int start, int end, int l, int r)
        {
            if(start>r || end<l)
                return 0;

            if(l<=start && end<=r)
                return tree[node];

            int mid = (start+end)/2;

            return Math.max(query(2*node+1,start,mid,l,r),query(2*node+2,mid+1,end,l,r));
        }
    }

    public List<Boolean> getResults(int[][] queries) 
    {
        List<Boolean> list = new ArrayList<>();
        TreeSet<Integer> treeset = new TreeSet<>();

        int d[] = new int[100000];
        d[0]=100000;

        Segment st = new Segment(100000);
        st.update(0,0,100000,0,100000);

        treeset.add(0);
        treeset.add(100000);

        for(int temp[] : queries)
        {
            if(temp[0]==1)
            {
                int left = treeset.floor(temp[1]);
                int right = treeset.ceiling(temp[1]);

                d[left]=temp[1]-left;
                d[temp[1]]=right-temp[1];

                st.update(0,0,100000,left,d[left]);
                st.update(0,0,100000,temp[1],d[temp[1]]);
                treeset.add(temp[1]);
            }
            else
            {
                if(temp[1]-temp[2]<0)
                {
                    list.add(false);
                    continue;
                }

                int max=st.query(0,0,100000,0,temp[1]-temp[2]);
                int last = treeset.floor(temp[1]);
                max=Math.max(max,temp[1]-last);

                if(max>=temp[2])
                    list.add(true);
                else
                    list.add(false);
            }
        }


        return list;
    }
}