class Solution 
{
    public boolean prime(String st)
    {
        int n = Integer.parseInt(st);
        int c=0;
        for(int i=2;i<=Math.sqrt(n);i++)
            if(n%i==0)
                c++;

        if(c==0 && n!=1)
            return true;
        else
            return false;
    }

    public boolean completePrime(int num) 
    {
        String st = Integer.toString(num);
        int n = st.length();

        for(int i=0;i<n;i++)
        {
            String a = st.substring(0,i+1);
            String b = st.substring(n-i-1);

            if(!prime(a) || !prime(b))
                return false;
        }

        return true;
    }
}