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
    }
    
    /**
     * 
     */
    public void fließen()
    {
        if(getOneObjectAtOffset(0,1,Wand.class)== null && getOneObjectAtOffset(0,1,Wasser.class)== null)
        {
            setLocation(getX(),getY()+1);
        }
        
    }
    
    /**
     * 
     */
    public void changePicture()
    {
        if(getOneObjectAtOffset(0,-1,Wasser.class)!= null)
        {
            setImage("Wasser(unbegrenzt).gif");
        }
    }
}
