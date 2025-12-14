class Solution 
{
    public String reverseWords(String s) 
    {
        Set<Character> set = Set.of('a','e','i','o','u');
        String arr[] = s.split(" ");

        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]);        

        int c=0;
        for(int i=0;i<arr[0].length();i++)
            if(set.contains(arr[0].charAt(i)))
                c++;

        for(int i=1;i<arr.length;i++)
        {
            int count=0;
            for(int j=0;j<arr[i].length();j++)
                if(set.contains(arr[i].charAt(j)))
                    count++;

            if(count==c)
                arr[i] = new StringBuilder(arr[i]).reverse().toString();

            sb.append(" ");
            sb.append(arr[i]);
        }

        return sb.toString();
    }
}