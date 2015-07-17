import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Kolben here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kolben extends Elektronik implements Undurchfallbar
{
    public int direction;
    public boolean verschoben = false;
    int xChange;
    int yChange;
    Block block = null;
    /**
     * Act - do whatever the Kolben wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setUndurchlässig();
        if(ein == true && verschoben == false)
        {
            ausfahren();
        }
        if(ein == false && verschoben == true)
        {
            einfahren();
        }
    }
    
    public Kolben(int x, int y, boolean ein, int dir)
    {
        super(x, y, ein);
        setRotation((dir-1)*90);
        direction = dir;
    }
    
    public void setNachbarblock()
    {
        if(direction == 1)
        {
            block = (Block)getOneTouchingObject("r", Block.class, 1);
            xChange = 16;
            yChange = 0;
        }
        if(direction == 2)
        {
            block = (Block)getOneTouchingObject("u", Block.class, 1);
            yChange = 16;
            xChange = 0;
        }
        if(direction == 3)
        {
            block = (Block)getOneTouchingObject("l", Block.class, 1);
            xChange = -16;
            yChange = 0;
        }
        if(direction == 4)
        {
            block = (Block)getOneTouchingObject("o", Block.class, 1);
            yChange = -16;
            xChange = 0;
        }
    }
    
    public void ausfahren()
    {
        setNachbarblock();
        setLocation(posX + xChange/2, posY + yChange/2);
        setImage("Kolben(ausgefahren).png");
        if(block != null && block.durchlässig() == false)
        {
            block.setLocation(block.getX() + xChange, block.getY() + yChange);
        }
        verschoben = true;
    }
    
    public void einfahren()
    {
        setNachbarblock();
        setLocation(posX, posY);
        setImage("Kolben(eingefahren).png");
        if(block != null && block.durchlässig() == false)
        {
            block.setLocation(block.getX() - xChange, block.getY() - yChange);
        }
        verschoben = false;
    }
}
