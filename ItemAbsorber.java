import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ItemLiqudierer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ItemAbsorber extends Elektronik
{
    boolean senkrecht = true;
    
    /**
     * Act - do whatever the ItemLiqudierer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setDurchlässig();
        absorbiereItems();
        setzeBild();
    }
    
    public ItemAbsorber(int x, int y, boolean ein, boolean s)
    {
        super(x, y, ein);
        senkrecht = s;
    }
    
    public void setzeBild()
    {
        if(senkrecht == true)
        {
            setImage("ItemAbsorber(senkrecht).png");
        } 
        else 
        {
            setImage("ItemAbsorber(waagerecht).png");
        }
    }
    
    /**
     * 
     */
    public void absorbiereItems()
    {
        Level w =(Level)getWorld();
        Joppa joppa = w.joppa1();
        if(getOneIntersectingObject(Joppa.class)!=null)
        {
            for(int i = 0; i < joppa.inv.größe();i++)
            {
                Item b = (Item)joppa.inv.ausgeben(i);
                if(b != null)
                {
                    int x = joppa.getX();
                    int y = joppa.getY();
                    getWorld().addObject(b, getX()- 2*(getX()-x), getY()- 2*(getY()-y));
                }
            }
        }
    }
}
