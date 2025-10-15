class Solution 
{
    public int[] decimalRepresentation(int n) 
    {
        List<Integer> list = new ArrayList<>();

        int x = (int)Math.log10(n)+1;
        int y=1;

        for(int i=1;i<=x;i++)
        {
            int d = n%10;
            if(d>0)
                list.add(d*y);

            y*=10;
            n/=10;
        }

        int ans[] = new int[list.size()];
        int c=0;

        for(int i=list.size()-1;i>=0;i--)
            ans[i]=list.get(c++);

        return ans;
    }
}