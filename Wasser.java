import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wasser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wasser extends Block
{
    public int v;
    
    public Wasser(int volume)
    {
        v = volume;
    }
    
    /**
     * Act - do whatever the Wasser wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        fließen();
        setDurchlässig();
        gravitationAus();
        addieren();
    }
    
    public int getVolume()
    {
        return v;
    }
    
    /**
     * 
     */
    public void addieren()
    {
        if(getOneObjectAtOffset(0, 0, Wasser.class) != null)
        {
            Wasser w = (Wasser)getOneObjectAtOffset(0, 0, Wasser.class);
            v = v + w.getVolume();
            getWorld().removeObject(w);
        }
    }
    
    /**
     * 
     */
    public int leftDistanceTo(Class c)
    {
        int dl = 0;
        for(int i = getX(); i>0; i--)
        {
            int x = getX();
            setLocation(i, getY());
            if(getOneIntersectingObject(c)!=null)
            {
                dl = i;
                setLocation(x, getY());
                break;
            }
        }
        return dl;
    }
    
    /**
     * 
     */
    public int rightDistanceTo(Class c)
    {
        int dr = 0;
        for(int h = getX(); h < getWorld().getWidth()-1; h++)
        {
            int x = getX();
            setLocation(h, getY());
            if(getOneIntersectingObject(c)!=null)
            {
                dr = h;
                setLocation(x, getY());
                break;
            }
        }
        return dr;
    }
    
    /**
     * 
     */
    public void fließen()
    {
        int dr = rightDistanceTo(Wand.class);
        int dl = leftDistanceTo(Wand.class);
        
        if(getOneObjectAtOffset(0,1,Wand.class)==null && getOneObjectAtOffset(0,1,Wasser.class)==null)
        {
            setLocation(getX(), getY()+1);
        }
        if(dr>=v)
        {
            for(int i = dr; i>=0; i--)
            {
                getWorld().addObject(new Wasser(1), getX()+i, getY());
                v = v - dr;
            }
        }
        if(dl>=v)
        {
            for(int h = dl; h>=0; h--)
            {
                getWorld().addObject(new Wasser(1), getX()-h, getY());
                v = v - dl;
            }
        }
    }
}
