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
    Start start = new Start();
    
    /**
     * Constructor for objects of class Level.
     * 
     */
    public Level()
    {    
        super(56*SIZE, 36*SIZE, 1);
    }
    
    public Audioplayer getAudioplayer()
    {
        return audio;
    }
    
    public void newWandRow(int x1, int y1, int x2, int y2)
    {
        for(int i = x1; i<=x2; i++)
        {
            for(int j = y1; j<=y2; j++)
            {
                addObject(new Wand(), unit(i), unit(j));
            }
        }
    }
    
    public void newFeuerRow(int x1, int y1, int x2, int y2)
    {
        for(int i = x1; i<=x2; i++)
        {
            for(int j = y1; j<=y2; j++)
            {
                addObject(new Feuer(), unit(i), unit(j));
            }
        }
    }
    
    public void newLeiterRow(int x1, int y1, int x2, int y2)
    {
        for(int i = x1; i<=x2; i++)
        {
            for(int j = y1; j<=y2; j++)
            {
                addObject(new Leiter(), unit(i), unit(j));
            }
        }
    }
    
    public int unit(int x)
    {
        return x*SIZE + MITTE;
    }
    
    public int levelType()
    {
        return level;
    }
    
    public void setLevel(int x)
    {
        level = x;
    }
    
    public void setzeSpieler(int x, int y)
    {
        addObject(start, x, y);
        addObject(joppa1, start.getX(), start.getY());
        joppa1.setLocation(start.getX(), start.getY());
    }
    
    /**
     * 
     */
    public void setzeStandart()
    {
        
        Lebensleiste lebensleiste = new Lebensleiste();
        addObject(lebensleiste, unit(5), unit(1));
        
        Luftleiste luftleiste = new Luftleiste();
        addObject(luftleiste, getWidth()-(unit(5)), unit(1));
        
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
            addObject(new Inventarfeld(i), (getWidth()/2) - (joppa1.inv.größe() * SIZE / 2) + unit(i), unit(1));
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
