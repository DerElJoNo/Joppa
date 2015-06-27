import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wasser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wasser extends Block
{
    /**
     * Act - do whatever the Wasser wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        fließen();
        changePicture();
        setDurchlässig();
        gravitationAus();
    }
    
    /**
     * 
     */
    public void fließen()
    {
        for(int i=9; i>0; i--)
        {
            setLocation(getX(), getY()+i);
            if(getOneIntersectingObject(Wasser.class)!=null || getOneIntersectingObject(Wand.class)!=null)
            {
                setLocation(getX(), getY()-i);
            }
            else
            {
                break;
            }
        }
    }
    
    /**
     * 
     */
    public void changePicture()
    {
        setLocation(getX(), getY()-8);
        if(getOneIntersectingObject(Wasser.class)!= null)
        {
            setImage("Wasser(unbegrenzt).gif");
        }
        setLocation(getX(), getY()+8);
    }
}
