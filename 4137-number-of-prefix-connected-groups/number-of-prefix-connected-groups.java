//written
class Solution 
{
    public int prefixConnected(String[] words, int k) 
    {
        int count=0;
        Map<String,Integer> map = new HashMap<>();

        for(String st : words)
        {
            if(st.length()<k)
                continue;

            String sub = st.substring(0,k);
            map.put(sub, map.getOrDefault(sub,0)+1);
        }

        for(int val : map.values())
            if(val>1)
                count++;

        return count;
    }
}