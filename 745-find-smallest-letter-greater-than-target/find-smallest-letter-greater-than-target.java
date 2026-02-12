class Solution 
{
    public char nextGreatestLetter(char[] letters, char target) 
    {
        char ans='z'+1;

        for(int i=0;i<letters.length;i++)
        {
            if(letters[i]-'a'>target-'a' && ans-'a'>letters[i]-'a')
                ans=letters[i];
        }

        if(ans=='z'+1)
            ans=letters[0];

        return ans;
    }
}