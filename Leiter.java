import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Leiter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Leiter extends Block implements Undurchfallbar
{
    /**
     * Act - do whatever the Leiter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setDurchlässig();
        gravitationAus();
    }    
}
