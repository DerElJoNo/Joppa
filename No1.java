import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class No1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class No1 extends Level
{

    /**
     * Constructor for objects of class No1.
     * 
     */
    public No1()
    {    
        setzeStandart();
        setLevel(1);
        setzeSpieler();
        level1();
    }
    
    public void level1()
    {
        for(int a = SIZE + MITTE; a <= getWidth(); a = a+SIZE)
        {
            addObject(new Wand(), a, 24*SIZE + MITTE);
        }
    }
}
