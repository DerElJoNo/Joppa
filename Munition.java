import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Munition here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Munition extends Block
{
    public double X1;
    public double Y1;
    public double X2;
    public double Y2;
    public int a;
    public int b;
    public int R;
    
    public Munition(int richtungx1,int richtungy1,int richtungx2, int richtungy2, int Rotation)
    {
        X1= (double) richtungx1;
        Y1= (double) richtungy1;
        X2= (double) richtungx2;
        Y2= (double) richtungy2;
        R= Rotation;
    }
    
    /**
     * Act - do whatever the Munition wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        fliegen();
        setRotation(R);
        auflösen();
        setDurchlässig();
    }
    
    /**
     * 
     */
    public void auflösen()
    {
        if(getOneObjectAtOffset(0,0,Wand.class) != null)
        {
            getWorld().removeObject(this);
        }
    }
    
    /**
     * 
     */
    public void fliegen()
    {
        setLocation(getX()+(int)(3*(X1-X2)/(Math.sqrt((X2-X1)*(X2-X1)+(Y2-Y1)*(Y2-Y1)))), getY()+(int)(3*(Y1-Y2)/(Math.sqrt((X2-X1)*(X2-X1)+(Y2-Y1)*(Y2-Y1)))));
    }
}
