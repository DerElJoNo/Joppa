import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class Block here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Block extends Actor
{
    /**
     * Act - do whatever the Block wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    
    public boolean durchlässig;
    public boolean gravitation;
    
    /**
     * 
     */
    public boolean gravitation()
    {
        return gravitation;
    }
    
    /**
     * 
     */
    public void gravitationAus()
    {
        gravitation = false;
    }
    
    /**
     * 
     */
    public void gravitationEin()
    {
        gravitation = true;
    }
    
    /**
     * 
     */
    public boolean durchlässig()
    {
        return durchlässig;
    }
    
    /**
     * 
     */
    public void setDurchlässig()
    {
        durchlässig = true;
    }
    
    /**
     * 
     */
    public void setUndurchlässig()
    {
        durchlässig = false;
    }
    
    public Actor getOneTouchingObject(String x, Class b, int offset)
    {
        Actor a = null;
        int XChange = 0;
        int YChange = 0;
        if(x == "u") {
            YChange = offset;
        } else if(x == "l") {
            XChange = -offset;
        } else if(x == "o") {
            YChange = -offset;
        } else if(x == "r") {
            XChange = offset;
        }
        
        setLocation(getX() + XChange, getY() + YChange);
        Actor iActor = getOneIntersectingObject(b);
        if(iActor!=null)
        {
            boolean correctDirection = false;
            
            if(x == "u") {
                correctDirection = iActor.getY() > getY();
            } else if(x == "l") {
                correctDirection = iActor.getX() < getX();
            } else if(x == "o") {
                correctDirection = iActor.getY() < getY();
            } else if(x == "r") {
                correctDirection = iActor.getX() > getX();
            }
            
            if(correctDirection) {
                a = iActor;
            }
        }
        setLocation(getX()-XChange,getY()-YChange);
        
        return a;
    }
    
    public List<Actor> getTouchingObjects(String x, Class b, int offset)
    {
        List<Actor> a = new ArrayList<Actor>();
        int XChange = 0;
        int YChange = 0;
        if(x == "u") {
            YChange = offset;
        } else if(x == "l") {
            XChange = -offset;
        } else if(x == "o") {
            YChange = -offset;
        } else if(x == "r") {
            XChange = offset;
        }

        setLocation(getX() + XChange, getY() + YChange);

        List<Actor> c = getIntersectingObjects(b);
        if(c!=null)
        {
            boolean correctDirection = false;
            for(int i=0; i< c.size(); i++)
            {
                Actor iActor = c.get(i);
                if(x == "u")
                {
                    correctDirection = iActor.getY() >= getY();
                }
                else if(x == "l")
                {
                    correctDirection = iActor.getX() <= getX();
                }
                else if(x == "o")
                {
                    correctDirection = iActor.getY() <= getY();
                }
                else if(x == "r")
                {
                    correctDirection = iActor.getX() >= getX();
                }
                if(correctDirection)
                {
                    a.add(iActor);
                }
            }
        }
        setLocation(getX()-XChange, getY()-YChange);
        return a;
    }
}
