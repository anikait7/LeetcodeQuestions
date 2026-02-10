class Solution 
{
    public int minimumDeletions(String s) 
    {
        int max=0;

        int pre_a[] = new int[s.length()+1];
        int pre_b[] = new int[s.length()+1];

        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='a')
                pre_a[i+1]=pre_a[i]+1;
            else
                pre_a[i+1]=pre_a[i];
        }

        for(int i=s.length()-1;i>=0;i--)
        {
            if(s.charAt(i)=='b')
                pre_b[i]=pre_b[i+1]+1;
            else
                pre_b[i]=pre_b[i+1];
        }

        for(int i=0;i<=s.length();i++)
            max=Math.max(max,pre_a[i]+pre_b[i]);

        return s.length()-max;
    }
}