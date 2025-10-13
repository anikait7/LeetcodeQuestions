class Solution 
{
    public List<String> removeAnagrams(String[] words) 
    {
        List<String> ans = new ArrayList<>();
        ans.add(words[0]);

        for(int i=1;i<words.length;i++)
            if(!isAnagram(words[i],words[i-1]))
                ans.add(words[i]);

        return ans;
    }

    private boolean isAnagram(String a, String b) 
    {
        if(a.length() != b.length()) 
            return false;

        int[] freq = new int[26];
        for(char c : a.toCharArray()) 
            freq[c-'a']++;
        for(char c : b.toCharArray()) 
            freq[c-'a']--;

        for(int f : freq) 
            if(f!=0)
                return false;
                
        return true;
    }
}
