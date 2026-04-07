class Robot 
{
    int r,c;
    int pos=0;
    int len;
    boolean hasMoved=false;

    public Robot(int width, int height) 
    {
        r=width;
        c=height;
        len = r*2+c*2-4;
    }
    
    public void step(int num) 
    {
        pos+=num;
        pos%=len;
        hasMoved=true;
    }
    
    public int[] getPos() 
    {
        int x=0,y=0;

        if(pos<r)
        {
            x=pos;  y=0;
        }
        else
        if(pos<r+c-1)
        {
            x=r-1;  y=pos-r+1;
        }
        else
        if(pos<r*2+c-2)
        {
            y=c-1;  x=r-1-(pos-r+1-c+1);
        }
        else
        {
            x=0;    y=c-1-(pos-r-r-c+3);
        }

        return new int[]{x,y};
    }
    
    public String getDir() 
    {
        if(!hasMoved)
            return "East";

        if(pos==0)
            return "South";

        if(pos<r)
            return "East";

        if(pos<r+c-1)
            return "North";

        if(pos<r*2+c-2)
            return "West";

        return "South";
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */