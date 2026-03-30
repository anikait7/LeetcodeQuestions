class Solution 
{
    public boolean checkStrings(String s1, String s2) 
    {
        List<Integer> even1 = new ArrayList<>();
        List<Integer> even2 = new ArrayList<>();

        List<Integer> odd1 = new ArrayList<>();
        List<Integer> odd2 = new ArrayList<>();

        for(int i=0;i<s1.length();i++)
        {
            if(i%2==0)
            {
                even1.add(s1.charAt(i)-'a');
                even2.add(s2.charAt(i)-'a');
            }
            else
            {
                odd1.add(s1.charAt(i)-'a');
                odd2.add(s2.charAt(i)-'a');
            }
        }

        int freq1[] = new int[26];
        int freq2[] = new int[26];

        for(int i=0;i<even1.size();i++)
        {
            freq1[even1.get(i)]++;
            freq1[even2.get(i)]--;
        }

        for(int i=0;i<odd1.size();i++)
        {
            freq2[odd1.get(i)]++;
            freq2[odd2.get(i)]--;
        }

        for(int i=0;i<26;i++)
            if(freq1[i]!=0 || freq2[i]!=0)
                return false;

        return true;
    }
}