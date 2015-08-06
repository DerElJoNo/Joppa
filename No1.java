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
        no1();    
        setzeStandart();
        setzeSpieler(unit(51), unit(34));
        setLevel(1);
    }
    
    public void no1()
    {
        addObject(new Ziel(), unit(35), unit(34));
        addObject(new Wand(), unit(54), unit(28));
        addObject(new Tür(), unit(47), unit(34));
        addObject(new Schlüssel(), unit(44), unit(27));
        
        newWandRow(33,24,33,34);
        newWandRow(33,23,54,23);
        newWandRow(34,32,46,32);
        newWandRow(47,29,47,33);
        newWandRow(40,28,52,28);
        newWandRow(40,24,40,27);
        newLeiterRow(53,28,53,34);
    }
}
