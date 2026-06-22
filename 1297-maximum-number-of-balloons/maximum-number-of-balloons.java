class Solution 
{
    public int maxNumberOfBalloons(String text) 
    {
        int freq[] = new int[26];

        for(int i=0;i<text.length();i++)
            freq[text.charAt(i)-'a']++;
        
        int b = freq['b'-'a'];
        b = Math.min(b,freq[0]);
        b = Math.min(b,freq['l'-'a']/2);
        b = Math.min(b,freq['o'-'a']/2);

        return Math.min(b,freq['n'-'a']);
    }
}