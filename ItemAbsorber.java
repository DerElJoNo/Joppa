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
        absorbiereItems();
        setzeBild();
    }
    
    public ItemAbsorber(int x, int y, boolean ein, boolean s)
    {
        super(x, y, ein);
        senkrecht = s;
        durchlässig = true;
    }
    
    public void setzeBild()
    {
        if(senkrecht == true)
        {
            if(ein == true)
            {
                setImage("ItemAbsorber(senkrecht).png");
            }
            else
            {
                setImage("ItemAbsorber(senkrecht).aus.png");
            }
        } 
        else 
        {
            if(ein == true)
            {
                setImage("ItemAbsorber(waagerecht).png");
            }
            else
            {
                setImage("ItemAbsorber(waagerecht).aus.png");
            }
        }
    }
    
    /**
     * 
     */
    public void absorbiereItems()
    {
        Level w =(Level)getWorld();
        Joppa joppa = w.joppa1();
        if(getOneIntersectingObject(Joppa.class)!=null && ein == true)
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
