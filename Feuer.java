import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Feuer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Feuer extends Actor
{
    /**
     * Act - do whatever the Feuer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        ChangePicture();
    }
    
    /**
     * 
     */
    public void ChangePicture()
    {
        if(getOneObjectAtOffset(1,0,Feuer.class)!=null)
        {
            setImage("Feuer(links begrenzt).gif");
        }
        if(getOneObjectAtOffset(-1,0,Feuer.class)!=null)
        {
            setImage("Feuer(rechts begrenzt).gif");
        }
        if(getOneObjectAtOffset(1,0,Feuer.class)!=null && getOneObjectAtOffset(-1,0,Feuer.class)!=null)
        {
            setImage("Feuer(unbegrenzt).gif");
        }
    }
}
