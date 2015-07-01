import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level extends World
{
    public static final int SIZE = 16;
    public int MITTE = SIZE / 2;
    int x;
    int y;
    int level;
    Joppa joppa1 = new Joppa();
    Audioplayer audio = new Audioplayer();
    
    /**
     * Constructor for objects of class Level.
     * 
     */
    public Level()
    {    
        super(45*SIZE, 30*SIZE, 1);
    }
    
    public Audioplayer getAudioplayer()
    {
        return audio;
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
        addObject(joppa1, 42 * SIZE + MITTE, 28 * SIZE + MITTE);
        joppa1.setLocation(42 * SIZE + MITTE, 28 * SIZE + MITTE);
    }
    
    /**
     * 
     */
    public void setzeStandart()
    {
        
        Lebensleiste lebensleiste = new Lebensleiste();
        addObject(lebensleiste, 5 * SIZE + MITTE, SIZE + MITTE);
        
        Luftleiste luftleiste = new Luftleiste();
        addObject(luftleiste, getWidth()-(5 * SIZE + MITTE), SIZE + MITTE);
        
        for(int a= MITTE; a<getWidth(); a = a + SIZE)
        {
            addObject(new Wand(), a, MITTE);
            addObject(new Wand(), a, getHeight() - MITTE);
        }
        
        for(int b= MITTE; b<getHeight(); b = b + SIZE)
        {
            addObject(new Wand(), MITTE, b);
            addObject(new Wand(), getWidth() - MITTE, b);
        }
        
        for(int i=0; i< joppa1.inv.größe(); i++)
        {
            addObject(new Inventarfeld(i), (getWidth()/2) - (joppa1.inv.größe() * SIZE / 2) + (i * SIZE) + MITTE, SIZE + MITTE);
        }
        
        audio.playBackgroundmusic();
    }
    
    /**
     * 
     */
    public Joppa joppa1()
    {
        return joppa1;
    }
}
