import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Kuchen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kuchen extends Item implements Essbar
{
    /**
     * Act - do whatever the Kuchen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setItemBild("Kuchen(Item).png");
    }
    
    public int getHungerpunkte() {
        return 15;
    }
}
