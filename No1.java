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
        level1();   
        setzeStandart();
        setLevel(1);
        setzeSpieler();
    }
    
    public void level1()
    {
        for(int a = SIZE + MITTE; a < 20*SIZE + MITTE; a = a+SIZE)
        {
            addObject(new Wand(), a, 24*SIZE + MITTE);
        }
        
        for(int b = 28*SIZE + MITTE; b >= 24*SIZE + MITTE; b = b-SIZE)
        {
            addObject(new Leiter(), 20*SIZE + MITTE, b);
        }
        
        SchalterDependList l = new SchalterDependList(5);
        l.einfügen(new ItemAbsorber(80, 80, true, true));
        l.einfügen(new ItemAbsorber(90, 90, true, true));
        l.einfügen(new ItemAbsorber(100, 100, true, true));
        l.einfügen(new ItemAbsorber(110, 110, true, true));
        l.einfügen(new ItemAbsorber(120, 120, true, true));
        addObject(new Schalter(l), 30*SIZE, MITTE + 28* SIZE);
        addObject(new Schalter(l), 35*SIZE, MITTE + 28* SIZE);
        
        addObject(new Tür(), 38*SIZE, MITTE + 28* SIZE);
        addObject(new Schlüssel(), 40*SIZE, MITTE + 28* SIZE);
    }
}
