class Solution 
{
    public String addBinary(String a, String b) 
    {
        int i,j,carry=0;
        StringBuilder sb = new StringBuilder();
        i=a.length()-1;
        j=b.length()-1;

        while (i>=0 || j>=0) 
        {
            if(i>=0)
                carry+=a.charAt(i--)-'0';

            if(j>=0)
                carry+=b.charAt(j--)-'0';

            sb.append(carry%2);
            carry/=2;
        }

        if(carry==1)
            sb.append("1");

        return sb.reverse().toString();
    }
}