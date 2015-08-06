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
        setzeBild();
        setzeDependends();
    }

    SchalterDependList list;
    public boolean ein;
    
    public void setzeBild()
    {
        if(ein == true)
        {
            setImage("Schalter(ein).png");
        }
        else
        {
            setImage("Schalter(aus).png");
        }
    }
    
    public Schalter(SchalterDependList dependList)
    {
        list = dependList;
        durchlässig = true;
    }

    public void setzeDependends()
    {
        if(list != null)
        {
            for(int i = 0; i < list.größe() ; i++)
            {
                Elektronik e = list.ausgeben(i);
                if(e != null)
                {
                    getWorld().addObject(e, e.getX(), e.getY());
                }
                list.einfügen(e);
            }
        }
    }

    public void umlegen()
    {
        if(list != null)
        {
            for(int i = 0; i < list.größe(); i++)
            {
                Elektronik e = list.ausgeben(i);
                e.umschalten();
                list.einfügen(e);
            }
        }
        
        if(ein == true)
        {
            ein = false;
        }
        else
        {
            ein = true;
        }
    }
}
