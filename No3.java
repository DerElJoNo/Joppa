import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class No3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class No3 extends Level
{

    /**
     * Constructor for objects of class No3.
     * 
     */
    public No3()
    {    
        setzeStandart();
        setLevel(3);
        setzeSpieler();
        generiereWelt();
    }
    
    public void generiereWelt()
    {
        Ziel ziel = new Ziel();
        addObject(ziel, 5, 28);
    }
}
