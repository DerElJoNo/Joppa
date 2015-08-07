import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class Guard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Guard extends Mob
{
    boolean right = true;
    boolean joppa = false;
    int v;
    int leben;
    int power;

    /**
     * Act - do whatever the Guard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        bewegen();
        angreifen(zielSuchen());
    }

    public Guard(int v, int leben, int power)
    {
        this.v = v;
        this.leben = leben;
        this.power = power;
        durchlässig = false;
    }

    public void bewegen()
    {
        int r;
        Block b;

        if(right)
        {
            r = v;
            b = (Block)getOneTouchingObject("r", Block.class, v);
            setImage("Joppa_rechts.png");
        }
        else
        {
            r = -v;
            b = (Block)getOneTouchingObject("l", Block.class, v);
            setImage("Joppa_links.png");
        }

        if(b == null || b.durchlässig() == true)
        {
            if(joppa == false)
            {
                setLocation(getX() + r, getY());
            }
        }

        if(b != null && b.durchlässig() != true)
        {
            if(right)
            {
                right = false;
            }
            else
            {
                right = true;
            }
        }
    }

    public void angreifen(Joppa ziel)
    {
        if(ziel == null)
        {
            return;
        }
        int zielX = ziel.getX();
        int zielY = ziel.getY();
        
        if(zielX < getX() && getOneTouchingObject("l", Joppa.class, v) == null)
        {
            for(int i=v; i>0; i--)
            {
                Block l = null;
                List<Actor> m = getTouchingObjects("l", Block.class, i);
                for(int j = 0; j < m.size(); j++)
                {
                    Block b = (Block) m.get(j);
                    if(b.durchlässig() == false)
                    {
                        l = b;
                    }
                }
                if(l == null)
                {
                    setLocation(getX()-i,getY());
                    break;
                }
            }
            right = false;
        }

        if(zielX > getX() && getOneTouchingObject("r", Joppa.class, v) == null)
        {
            for(int i=v; i>0; i--)
            {
                Block r = null;
                List<Actor> m = getTouchingObjects("r", Block.class, i);
                for(int j = 0; j < m.size(); j++)
                {
                    Block b = (Block) m.get(j);
                    if(b.durchlässig() == false)
                    {
                        r = b;
                    }
                }
                if(r == null)
                {
                    setLocation(getX()+i,getY());
                    break;
                }
            }
            right = true;
        }
    }

    public Joppa zielSuchen()
    {
        Joppa ziel = null;
        for(int i = 0; i<15*v; i++)
        {
            if((Joppa)getOneTouchingObject("r", Joppa.class, i) != null)
            {
                ziel = (Joppa)getOneTouchingObject("r", Joppa.class, i);
            }
            else
            {
                ziel = (Joppa)getOneTouchingObject("l", Joppa.class, i);
            }

            if(ziel != null)
            {
                joppa = true;
                break;
            }
            else
            {
                joppa = false;
            }
        }
        return ziel;
    }
}
