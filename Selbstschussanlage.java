import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Selbstschussanlage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Selbstschussanlage extends Block
{
    public int Munition=6;
    /**
     * Act - do whatever the Selbstschussanlage wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Actor a = (Actor)getObjectsInRange(30,Joppa.class).get(0);
        int x = a.getX();
        int y = a.getY();
        if(getX() <= x+7 && getX() >= x-7 && getY() <= y+7 && getY() >= y-7)
        {
            zielen();
            schießen();
        }
        nachladen();
        setUndurchlässig();
    }   
    
    /**
     * 
     */
    public void nachladen()
    {
        if(Munition <= 6)
        {
            Munition=Munition+1;
        }
    }
    
    /**
     * 
     */
    public void zielen()
    {        
        Actor a = (Actor)getObjectsInRange(30,Joppa.class).get(0);
        int x = a.getX();
        int y = a.getY();
        turnTowards(x,y);
    }
    
    /**
     * 
     */
    public void schießen()
    {
        if( Munition>= 0)
        {
            Actor a = (Actor)getObjectsInRange(30,Joppa.class).get(0);
            int x = a.getX();
            int y = a.getY();
            int Rotation = getRotation();
            Munition b = new Munition(x,y,getX(),getY(),Rotation);
            getWorld().addObject(b,getX(),getY());
            Munition--;
        }
    }
}
