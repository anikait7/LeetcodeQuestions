class Solution 
{
    public int func(int x, int y)
    {
        while(y!=0)
        {
            int temp = y;
            y=x%y;
            x=temp;
        }

        return x;
    }

    public String findLexSmallestString(String s, int a, int b) 
    {
        Set<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(s);

        String min=s;

        while(!queue.isEmpty())
        {
            String st = queue.poll();
            if(min.compareTo(st)>0)
                min=st;
            
            for(int i=1;i<=10;i++)
            {
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<st.length();j++)
                {
                    if(j%2==0)
                        sb.append(st.charAt(j));
                    else
                    {
                        int x = a+st.charAt(j)-'0';
                        x%=10;
                        sb.append((char)('0'+x));
                    }
                }

                if(!set.contains(sb.toString()))
                {
                    set.add(sb.toString());
                    queue.add(sb.toString());
                }
            }
            
            int gcd = func(b,st.length());
            int n = st.length();
            int unique = n/gcd;

            for(int i=0;i<unique;i++)
            {
                int shift = (i*b)%n;
                String xyz = st.substring(n-shift)+st.substring(0,n-shift);

                if(!set.contains(xyz))
                {
                    set.add(xyz);
                    queue.add(xyz);
                }
            }
        }

        return min;
    }
}