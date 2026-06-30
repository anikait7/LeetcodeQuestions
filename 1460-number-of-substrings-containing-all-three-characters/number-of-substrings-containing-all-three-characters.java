class Solution 
{
    public int numberOfSubstrings(String s) 
    {
        int count=0;
        int arr[] = new int[3];
        int left=0;

        for(int i=0;i<s.length();i++)
        {
            arr[s.charAt(i)-'a']++;

            while(arr[0]*arr[1]*arr[2]>=1)
            {
                count+=s.length()-i;
                arr[s.charAt(left++)-'a']--;
            }
        }

        return count;
    }
}