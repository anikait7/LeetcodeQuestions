class Solution 
{
    Set<String> set = new HashSet<>();

    public String recursive(int len, String ans)
    {
        if(len==0)
        {
            if(set.contains(ans))
                return "";
            else
                return ans;
        }

        String st;

        st=recursive(len-1,ans+"0");
        if(!st.equals(""))
            return st;

        st=recursive(len-1,ans+"1");
        if(!st.equals(""))
            return st;

        return "";
    }

    public String findDifferentBinaryString(String[] nums) 
    {
        int len=nums.length;

        for(int i=0;i<nums.length;i++)
            set.add(nums[i]);
        
        String st = recursive(len,"");

        return st;
    }
}