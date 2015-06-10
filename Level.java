import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level extends World
{
    public static final int SIZE = 17;
    int x;
    int y;
    int level;
    Joppa joppa1 = new Joppa();
    /**
     * Constructor for objects of class Level.
     * 
     */
    public Level()
    {    
        super(765, 510, 1);
    }
    
    public int levelType()
    {
        return level;
    }
    
    public void setLevel(int x)
    {
        level = x;
    }
    
    public void setzeSpieler()
    {
        addObject(joppa1, 42, 28);
        joppa1.setLocation(42, 28);
    }
    
    /**
     * 
     */
    public void setzeStandart()
    {
        
        Lebensleiste lebensleiste = new Lebensleiste();
        addObject(lebensleiste, 5 * SIZE, SIZE);
        
        Luftleiste luftleiste = new Luftleiste();
        addObject(luftleiste, getWidth()-(5 * SIZE), SIZE);
        
        for(int a=0; a<getWidth(); a++)
        {
            addObject(new Wand(), a, 0);
            addObject(new Wand(), a, getHeight()-1);
        }
        
        for(int b=1; b<getHeight(); b++)
        {
            addObject(new Wand(), 0, b);
            addObject(new Wand(), getWidth()-1, b);
        }
        
        for(int i=0; i< joppa1.inv.größe(); i++)
        {
            addObject(new Inventarfeld(i), getWidth() - joppa1.inv.größe()/2 + i * SIZE, SIZE);
        }
    }
    
    /**
     * 
     */
    public Joppa joppa1()
    {
        return joppa1;
    }
}
