import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Munition here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Munition extends Block
{
    public int R;
    public final double V=8;
    
    public Munition(int Rotation)
    {
        R= Rotation;
    }
    
    /**
     * Act - do whatever the Munition wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        fliegen();
        setRotation(R);
        auflösen();
        setDurchlässig();
    }
    
    /**
     * 
     */
    public void auflösen()
    {
        if(getOneIntersectingObject(Wand.class) != null)
        {
            getWorld().removeObject(this);
        }
    }
    
    /**
     * 
     */
    public void fliegen()
    {
        double direction = Math.toRadians(R);
        double dx = Math.cos(direction) * V;
        double dy = Math.sin(direction) * V;
        setLocation((double)getX() + dx, (double)getY() + dy);
    }
    
    /**
     * 
     */
    public void setLocation(double x, double y) 
    {
        setLocation((int) (x + 0.5), (int) (y + 0.5));
    }
}
