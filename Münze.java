import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Münze here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Münze extends Actor
{
    int wert;
    public Münze(int wert)
    {
        this.wert = wert;
    }
    
    public int getWert()
    {
        return wert;
    }
}
