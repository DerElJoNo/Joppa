import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Schalter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Schalter extends Block
{
    /**
     * Act - do whatever the Schalter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setzeDependends();
    }

    SchalterDependList list;

    public Schalter(SchalterDependList dependList)
    {
        list = dependList;
    }

    public void setzeDependends()
    {
        for(int i = 0; i < list.größe() ; i++)
        {
            Elektronik e = list.ausgeben(i);
            if(e != null)
            {
                getWorld().addObject(e, e.getX(), e.getY());
            }
        }
    }
}
