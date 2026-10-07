class Solution 
{
    public String evaluate(String s, List<List<String>> knowledge) 
    {
        Map<String,String> map = new HashMap<>();
        for(int i=0;i<knowledge.size();i++)
            map.put(knowledge.get(i).get(0),knowledge.get(i).get(1));
        
        StringBuilder sb = new StringBuilder();

        while(true)
        {
            int x = s.indexOf('(');
            if(x==-1)
                break;

            int y = s.indexOf(')');

            sb.append(s.substring(0,x));

            String val = s.substring(x+1,y);
            if(map.containsKey(val))
                sb.append(map.get(val));
            else
                sb.append("?");

            s=s.substring(y+1);
        }

        sb.append(s);
        return sb.toString();
    }
}