import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Selbstschussanlage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Selbstschussanlage extends Block implements Undurchfallbar
{
    public int munition;
    public final int Range=50;
    public long zeit;
    public boolean geladen;

    /**
     * Act - do whatever the Selbstschussanlage wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        eliminateTarget(Joppa.class);
        setUndurchlässig();
    }
    
    /**
     * 
     */
    public void eliminateTarget(Class c)
    {
        Actor a = (Actor)getObjectsInRange(800,c).get(0);
        int x = a.getX();
        int y = a.getY();
        if(getOneObjectInRange(100,c)!=null)
        {
            zielen(a);
            schießen();
        }
    }
    
    /**
     * 
     */
    public void nachladen()
    {
        if(zeitVergangen()>500 && munition > 0)
        {
            geladen = true;
        }
        if(munition == 0 && zeitVergangen() > 2000)
        {
            munition = 6;
        }
    }
    
    /**
     * 
     */
    public void zeitMessen()
    {
        zeit = System.currentTimeMillis();
    }
    
    /**
     * 
     */
    public int zeitVergangen()
    {
        return (int) (System.currentTimeMillis() - zeit);
    }
    
    /**
     * 
     */
    public void zielen(Actor a)
    {
        turnTowards(a.getX(),a.getY());
    }
    
    /**
     * 
     */
    public void schießen()
    {
        if(geladen == true)
        {
            int Rotation = getRotation();
            Munition b = new Munition(Rotation);
            getWorld().addObject(b,getX(),getY());
            geladen = false;
            munition--;
            zeitMessen();
        }
        else
        {
            nachladen();
        }
    }
    
    /**
     * 
     */
    public Actor getOneObjectInRange(int Range, Class c)
    {
        if(getObjectsInRange(Range,c).size()>0)
        {
            Actor a =(Actor)getObjectsInRange(Range,c).get(0);
            return a;
        }
        return null;
    }
}
