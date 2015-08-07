import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ziel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ziel extends Actor
{
    /**
     * Act - do whatever the Ziel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(getOneIntersectingObject(Joppa.class)!=null && Greenfoot.isKeyDown("o"))
        {
            Level aktuellesLevel = (Level) getWorld();
            Level naechstesLevel = LevelManager.getInstance().getNextLevel(aktuellesLevel);
            Greenfoot.setWorld(naechstesLevel);
        }
    }
}
