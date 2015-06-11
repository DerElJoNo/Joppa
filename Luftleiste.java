import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Luftleiste here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Luftleiste extends Actor
{
    public int Luft;
    /**
     * Act - do whatever the Lebensleiste wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        World world = getWorld();
        Level welt = (Level)world;
        Joppa joppa1 = welt.joppa1();
        Luft = joppa1.Luft();
        
        setImage(new GreenfootImage(102,16));
        GreenfootImage Leiste = getImage();
        Leiste.setColor(Color.GRAY);
        Leiste.fillRect(0,0,102,16);
        
        if(Luft >=50)
        {
            Leiste.setColor(Color.CYAN);
            Leiste.fillRect(1,1,Luft,14);
        }
        if(Luft <=49)
        {
            Leiste.setColor(Color.blue);
            Leiste.fillRect(1,1,Luft,14);
        }
    }
}
