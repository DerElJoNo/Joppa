import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tür here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tür extends Block
{
    public boolean durchlässig = false;
    
    /**
     * Act - do whatever the Tür wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
    }
    
    /**
     * 
     */
    public void open()
    {
        durchlässig = true;
        setImage("Tür(geöffnet).png");
    }
    
    /**
     * 
     */
    public void close()
    {
        durchlässig = false;
        setImage("Tür(geschlossen).png");
    }
    
    /**
     * 
     */
    public boolean offen()
    {
        return durchlässig;
    }
}
