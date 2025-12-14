class Solution 
{
    public int maxDistinct(String s) 
    {
        int arr[] = new int[26];
        int c=0;

        for(int i=0;i<s.length();i++)
        {
            int ch = s.charAt(i)-'a';
            if(arr[ch]==0)
            {
                c++;
                arr[ch]++;
            }
        }

        return c;
    }
}