class Solution 
{
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) 
    {
        List<String> ans = new ArrayList<>();
        
        List<String> a = new ArrayList<>();
        List<String> b = new ArrayList<>();
        List<String> c = new ArrayList<>();
        List<String> d = new ArrayList<>();

        for(int i=0;i<code.length;i++)
        {
            if(!isActive[i] || code[i].length()==0)
                continue;

            if(businessLine[i].equals("electronics") || businessLine[i].equals("grocery") || businessLine[i].equals("pharmacy") || businessLine[i].equals("restaurant"))
            {
                boolean flag=true;
                for(int j=0;j<code[i].length();j++)
                {
                    if((code[i].charAt(j)>='a' && code[i].charAt(j)<='z') || (code[i].charAt(j)>='A' && code[i].charAt(j)<='Z') || (code[i].charAt(j)>='0' && code[i].charAt(j)<='9')|| code[i].charAt(j)=='_')
                        continue;
                    else
                        flag=false;

                    if(!flag)
                        break;
                }

                if(flag)
                {
                    if(businessLine[i].equals("electronics"))
                        a.add(code[i]);
                    else
                    if(businessLine[i].equals("grocery"))
                        b.add(code[i]);
                    else
                    if(businessLine[i].equals("pharmacy"))
                        c.add(code[i]);
                    else
                        d.add(code[i]);
                }
            }
        }

        Collections.sort(a);
        Collections.sort(b);
        Collections.sort(c);
        Collections.sort(d);

        ans.addAll(a);
        ans.addAll(b);
        ans.addAll(c);
        ans.addAll(d);
        return ans;
    }
}