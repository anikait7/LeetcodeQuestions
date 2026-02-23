class Solution 
{
    List<String> list = new ArrayList<>();

    public void compute(String s, int k)
    {
        if(s.length()==k)
        {
            list.add(s);
            return ;
        }

        compute(s+"0",k);
        compute(s+"1",k);
    }

    public boolean hasAllCodes(String s, int k) 
    {
        compute("",k);
        Set<String> set = new HashSet<>();
        for(int i=0;i<=s.length()-k;i++)
            set.add(s.substring(i,i+k));

        for(int i=0;i<list.size();i++)
        {
            if(!set.contains(list.get(i)))
                return false;
        }

        return true;
    }
}