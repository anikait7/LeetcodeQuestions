class Solution 
{
    public String makeLargestSpecial(String s) 
    {
        int len = s.length();
        String st="";

        int one=0;       int prev=0;

        List<String> list = new ArrayList<>();

        for(int i=0;i<len;i++)
        {
            int x = s.charAt(i)-'0';

            if(x==1)
                one++;
            else
                one--;

            if(one==0)
            {
                st=makeLargestSpecial(s.substring(prev+1,i));
                prev=i+1;
                list.add("1"+st+"0");
            }
        }

        st="";
        Collections.sort(list); 
        for(int i=list.size()-1;i>=0;i--)
            st+=list.get(i);

        return st;
    }
}