import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Welt extends World
{
    
    Joppa joppa1 = new Joppa();
    
    public int i=0;
    /**
     * Constructor for objects of class Level1.
     * 
     */
    public Welt()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(35, 20, 17);
        
        generiereWelt();
        
        setzteSpieler();
    }
    
    /**
     * 
     */
    public void setzteSpieler()
    {
        addObject(joppa1,33,18);
        Lebensleiste lebensleiste = new Lebensleiste();
        addObject(lebensleiste,3,1);
        Luftleiste luftleiste = new Luftleiste();
        addObject(luftleiste,31,1);
    }
    
    /**
     * 
     */
    public Joppa joppa1()
    {
        return joppa1;
    }
    
    /**
     * 
     */
    public void generiereWelt()
    {
        for(int i=0; i<35; i++)
        {
            addObject(new Wand(), i, 0);
        }
        
        for(int a=0; a<35; a++)
        {
            addObject(new Wand(), a, 19);
        }
        
        for(int b=11; b<17; b++)
        {
            addObject(new Wand(), b, 16);
        }
        
        for(int c=0; c<10; c++)
        {
            addObject(new Wand(), c, 16);
        }
        
        for(int d=18; d<36; d++)
        {
            addObject(new Wand(), d, 16);
        }
        
        for(int e=16; e<19; e++)
        {
            addObject(new Leiter(), 17, e);
        }
        
        for(int f=16; f<19; f++)
        {
            addObject(new Leiter(), 10, f);
        }
        
        for(int g=29; g<36; g++)
        {
            addObject(new Wasser(), g, 15); addObject(new Wasser(), g, 14);
        }
        
        Wand wand1 = new Wand();
        addObject(wand1,28,15);
        
        Wand wand2 = new Wand();
        addObject(wand2,13,18);
        
        Wand wand3 = new Wand();
        addObject(wand3,13,17);
        
        Wand wand5 = new Wand();
        addObject(wand5,28,14);
        
        Wand wand6 = new Wand();
        addObject(wand6,27,15);
        
        Selbstschussanlage selbstschussanlage1 = new Selbstschussanlage();
        addObject(selbstschussanlage1,16,12);
        
        Wand wand4 = new Wand();
        addObject(wand4,28,18);
        
        Feuer feuer1 = new Feuer();
        addObject(feuer1,3,15);
        
        Feuer feuer2 = new Feuer();
        addObject(feuer2,4,15);
        
        Feuer feuer3 = new Feuer();
        addObject(feuer3,5,15);
    }
        
    
    
}
