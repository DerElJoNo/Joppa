import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Item here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Item extends Actor
{
    /**
     * Act - do whatever the Item wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
    }
    
    public boolean verzehr;
    public GreenfootImage itemBild;
    public int hungerpunkte;
    
    public GreenfootImage getItemBild()
    {
        return itemBild;
    }
    
    public void setItemBild(String x)
    {
        itemBild = new GreenfootImage(x);
    }
}
