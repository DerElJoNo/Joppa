import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Lebensleiste here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lebensleiste extends Actor
{
    public int Leben;
    /**
     * Act - do whatever the Lebensleiste wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        World world = getWorld();
        Welt welt = (Welt)world;
        Joppa joppa1 = welt.joppa1();
        Leben = joppa1.Leben();
        
        setImage(new GreenfootImage(102,17));
        GreenfootImage Leiste = getImage();
        Leiste.setColor(Color.GRAY);
        Leiste.fillRect(0,0,102,17);
        
        if(Leben>=66)
        {
            Leiste.setColor(Color.GREEN);
            Leiste.fillRect(1,1,Leben,15);
        }
        if(Leben>=34 && Leben <=65)
        {
            Leiste.setColor(Color.YELLOW);
            Leiste.fillRect(1,1,Leben,15);
        }
        if(Leben <=33)
        {
            Leiste.setColor(Color.RED);
            Leiste.fillRect(1,1,Leben,15);
        }
    }
}
