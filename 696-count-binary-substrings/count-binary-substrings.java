class Solution 
{
    public int countBinarySubstrings(String s) 
    {
        List<Integer> list = new ArrayList<>();
        int count=0;

        s+=" ";     int c=1;
        for(int i=1;i<s.length();i++)
        {
            if(s.charAt(i)==s.charAt(i-1))
                c++;
            else
            {
                list.add(c);
                c=1;
            }
        }

        for(int i=1;i<list.size();i++)
            count+=Math.min(list.get(i),list.get(i-1));

        return count;
    }
}