class Solution 
{
    public List<String> twoEditWords(String[] queries, String[] dictionary) 
    {
        List<String> ans = new ArrayList<>();

        for(String st : queries)
        {
            for(int i=0;i<dictionary.length;i++)
            {
                int c=0;
                for(int j=0;j<st.length();j++)
                {
                    if(st.charAt(j)!=dictionary[i].charAt(j))
                        c++;
                }

                if(c<=2)
                {
                    ans.add(st);
                    break;
                }
            }
        }


        return ans;
    }
}