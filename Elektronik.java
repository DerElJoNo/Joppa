import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elektronik here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elektronik extends Block
{
    /**
     * Act - do whatever the Elektronik wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(posX, posY);
    }
    
    public int posX;
    public int posY;
    public boolean ein;
    
    public Elektronik(int x, int y, boolean eingeschaltet)
    {
        posX = x;
        posY = y;
        ein = eingeschaltet;
    }
    
    public int getX()
    {
        return posX;
    }
    
    public int getY()
    {
        return posY;
    }
    
    public void umschalten()
    {
        if(ein == true)
        {
            ein = false;
        }
        else
        {
            ein = true;
        }
    }
    
    public void einschalten()
    {
        ein = true;
    }
    
    public void ausschalten()
    {
        ein = false;
    }
    
    public boolean eingeschaltet()
    {
        return ein;
    }
}
