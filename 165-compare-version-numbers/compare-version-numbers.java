class Solution 
{
    public int compareVersion(String version1, String version2) 
    {
        version1+='.';      version2+='.';

        List<Long> list1 = new ArrayList<>();
        List<Long> list2 = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<version1.length();i++)
        {
            char ch = version1.charAt(i);
            if(ch=='.')
            {
                String st = sb.toString();
                Long a = Long.parseLong(st);
                list1.add(a);
                sb = new StringBuilder();
            }
            else
                sb.append(ch);
        }

        for(int i=0;i<version2.length();i++)
        {
            char ch = version2.charAt(i);
            if(ch=='.')
            {
                String st = sb.toString();
                Long a = Long.parseLong(st);
                list2.add(a);
                sb = new StringBuilder();
            }
            else
                sb.append(ch);
        }

        int i;
        for(i=0;i<Math.min(list1.size(),list2.size());i++)
        {
            if(list1.get(i)>list2.get(i))
                return 1;

            if(list2.get(i)>list1.get(i))
                return -1;
        }

        for(int j=i;j<list1.size();j++)
            if(list1.get(j)>0)
                return 1;

        for(int j=i;j<list2.size();j++)
            if(list2.get(j)>0)
                return -1;

        return 0;
    }
}