class Solution 
{
    public String lexSmallest(String s) 
    {
        String min = s;

        for(int i=1;i<s.length();i++)
        {
            String a = s.substring(0,i+1);
            String b = s.substring(i+1);

            
            StringBuilder sb = new StringBuilder(a);
            sb.reverse();

            if(min.compareTo(sb.toString()+b)>0)
                min=sb.toString()+b;
        }

        for(int i=s.length()-2;i>=0;i--)
        {
            String a = s.substring(i);
            String b = s.substring(0,i);
            
            StringBuilder sb = new StringBuilder(a);
            sb.reverse();

            if(min.compareTo(b+sb.toString())>0)
                min=b+sb.toString();
        }

        return min;
    }
}