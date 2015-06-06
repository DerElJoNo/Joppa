import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Inventarfeld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inventarfeld extends Actor
{
    /**
     * Act - do whatever the Inventarfeld wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        World world = getWorld();
        Level welt = (Level)world;
        Joppa joppa1 = welt.joppa1();
        inv = joppa1.inv();
        Item i = inv.ausgeben(position);
        inv.einfügen(i);
        GreenfootImage a = getImage();
        if(i==null)
        {
            setImage("Inventar.png");
        }
        if(i!=null)
        {
            a.drawImage(i.itemBild(),0,0);
        }
    }
    public Inventar inv;
    public int position;
    
    public Inventarfeld(int x)
    {
        position = x;
    }
}
