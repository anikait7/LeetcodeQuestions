class Solution 
{
    public int minimumPushes(String word) 
    {
        int freq[] = new int[26];

        for(int i=0;i<word.length();i++)
            freq[word.charAt(i)-'a']++;

        Arrays.sort(freq);
        int c=8;
        int count=0;
        int fact=1;

        for(int i=25;i>=0 && freq[i]!=0;i--)
        {
            c--;
            count+=freq[i]*fact;

            if(c==0)
            {
                c=8;
                fact++;
            }
        }

        return count;
    }
}