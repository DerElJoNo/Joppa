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
        generiereWelt();
    }
    
    public void generiereWelt()
    {
        Ziel ziel = new Ziel();
        addObject(ziel, 5, 28);
    }
}
