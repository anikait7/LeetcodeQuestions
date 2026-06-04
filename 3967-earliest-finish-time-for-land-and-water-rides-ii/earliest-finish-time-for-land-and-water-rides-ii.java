class Solution 
{
    public int earliestFinishTime(int[] land, int[] landtime, int[] water, int[] watertime) 
    {
        int p = land.length;
        int q = water.length;

        int l[][] = new int[p][2];
        int w[][] = new int[q][2];

        for(int i=0;i<p;i++)
        {
            l[i][0]=land[i];
            l[i][1]=land[i]+landtime[i];
        }

        Arrays.sort(l, (a,b) -> a[1]!=b[1]? a[1]-b[1] : a[0]-b[0]);
        
        int pre_land[] = new int[p];
        pre_land[0]=l[0][1]-l[0][0];

        for(int i=1;i<p;i++)
            pre_land[i]=Math.min(pre_land[i-1],l[i][1]-l[i][0]);        

        for(int i=0;i<q;i++)
        {
            w[i][0]=water[i];
            w[i][1]=water[i]+watertime[i];
        }

        Arrays.sort(w, (a,b) -> a[1]!=b[1]? a[1]-b[1] : a[0]-b[0]);

        int pre_water[] = new int[q];
        pre_water[0]=w[0][1]-w[0][0];

        for(int i=1;i<q;i++)
            pre_water[i]=Math.min(pre_water[i-1],w[i][1]-w[i][0]); 

        //start with land end with water we need pre_water here
        int endtime1=l[0][1];
        int max1 = Integer.MAX_VALUE;
        
        for(int i=0;i<q;i++)
        {
            if(endtime1>w[i][0])
                max1=Math.min(max1,endtime1+w[i][1]-w[i][0]);
            else
                max1=Math.min(max1,w[i][1]);
        }

        //start with water and end with land we need pre_land here
        int endtime2=w[0][1];
        int max2=Integer.MAX_VALUE;

        for(int i=0;i<p;i++)
        {
            if(endtime2>l[i][0])
                max2=Math.min(max2,endtime2+l[i][1]-l[i][0]);
            else
                max2=Math.min(max2,l[i][1]);
        }

        return Math.min(max1,max2);
    }
}

/*
land : [1,6] [2,7], [6,7] [10, 21]
water: [4,9],[7,9]
*/