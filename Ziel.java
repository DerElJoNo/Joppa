import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ziel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ziel extends Actor
{
    int level;
    int nextLevel;
    /**
     * Act - do whatever the Ziel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(getOneObjectAtOffset(0,0,Joppa.class)!=null && Greenfoot.isKeyDown("o"))
        {
            World welt = getWorld();
            Level aktuellesLevel = (Level) welt;
            Level naechstesLevel = LevelManager.getInstance().getNextLevel(aktuellesLevel);
            Greenfoot.setWorld(naechstesLevel);
        }
    }
}
