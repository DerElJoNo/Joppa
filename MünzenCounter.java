import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class MünzenCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MünzenCounter extends Actor
{
    public float münzen = 0;
    Joppa j;
    public MünzenCounter(Joppa j)
    {
        this.j = j;
    }
    
    /**
     * Act - do whatever the MünzenCounter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        münzen = (float)j.münzen;
        GreenfootImage score = null;
        
        if(münzen < 1000)
        {
            score = new GreenfootImage(String.format("%03d", (int)münzen) , 18, Color.BLACK, Color.WHITE);
        }
        if(münzen >= 1000 && münzen < 1000000)
        {
            score = new GreenfootImage(String.format("%.2f", münzen/1000) + " K", 18, Color.BLACK, Color.WHITE);
        }
        if(münzen >= 1000000)
        {
            score = new GreenfootImage(String.format("%.2f", münzen/1000000) + " Mio.", 18, Color.BLACK, Color.WHITE);
        }
        
        GreenfootImage background = new GreenfootImage(80, 16);
        background.setColor(Color.WHITE);
        background.fillRect(0, 0, 80, 16);
        background.drawImage(score, 60 - score.getWidth(), 0);
        background.drawImage(new GreenfootImage("Münze.gif"), 64, 0);
        setImage(background);
    }
}
