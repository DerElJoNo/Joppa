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
        
        for(int a = 34; a>23; a--)
        {
            addObject(new Wand(), unit(33), unit(a));
        }
        
        for(int b = 33; b<55; b++)
        {
            addObject(new Wand(), unit(b), unit(23));
        }
        
        for(int c = 34; c<47; c++)
        {
            addObject(new Wand(), unit(c), unit(32));
        }
        
        for(int d = 33; d>28; d--)
        {
            addObject(new Wand(), unit(47), unit(d));
        }
        
        for(int e = 40; e<53; e++)
        {
            addObject(new Wand(), unit(e), unit(28));
        }
        
        for(int f = 24; f<28; f++)
        {
            addObject(new Wand(), unit(40), unit(f));
        }
        
        for(int g = 34; g>27; g--)
        {
            addObject(new Leiter(), unit(53), unit(g));
        }
    }
}
