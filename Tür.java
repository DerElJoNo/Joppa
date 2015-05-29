import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tür here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tür extends Actor
{
    public boolean offen = false;
    
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
        offen = true;
        setImage("Tür(offen).png");
    }
    
    /**
     * 
     */
    public void close()
    {
        offen = false;
        setImage("Tür(geschlossen).png");
    }
}
