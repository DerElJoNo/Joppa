import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class Joppa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Joppa extends Actor
{
    public int Leben=100;
    public int Fallhöhe;
    public int x;
    public int y;
    public int Luft=100;
    public Inventar inv;
    public GreenfootImage joppa;
    public boolean left;
    private final int V = 8;

    public Joppa()
    {
        inv = new Inventar();
    }

    /**
     * Act - do whatever the Joppa wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        bewegen();
        zurücksetzen();
        verbrennen();
        getroffenWerden();
        öffnen();
        aufsammeln();
        fallen();
        setzen();
        essen();
        umlegen();
    }

    public Inventar inv()
    {
        return inv;
    }

    /**
     * 
     */
    public void umlegen()
    {
        if (Greenfoot.isKeyDown("f") && getOneIntersectingObject(Schalter.class) != null)
        {
            Schalter s = (Schalter)getOneIntersectingObject(Schalter.class);
            s.umlegen();
        }        
    }

    /**
     * 
     */
    public void essen()
    {
        if(getOneIntersectingObject(Item.class)!=null && Greenfoot.isKeyDown("q"))
        {
            Item i = (Item)getOneIntersectingObject(Item.class);
            if( i instanceof Essbar ){
                Essbar essen = (Essbar) i;
                if( 100 >= essen.getHungerpunkte() + Leben) 
                {
                    Leben = Leben + essen.getHungerpunkte();
                }
                else
                {
                    Leben = 100;
                }
                getWorld().removeObject(i);
            }
        }
    }

    /**
     * 
     */
    public void setzen()
    {
        for(int i=0; i<inv.größe(); i++)
        {
            if(Greenfoot.isKeyDown(Integer.toString(i+1)))
            {
                Item a = inv.ausgeben(i);
                if(a!=null)
                {
                    if(left==true)
                    {
                        getWorld().addObject(a,getX()-16,getY());
                    }
                    if(left!=true)
                    {
                        getWorld().addObject(a,getX()+16,getY());
                    }
                }
            }
        }
    }

    /**
     * 
     */
    public void aufsammeln()
    {
        if(getOneIntersectingObject(Item.class)!=null && Greenfoot.isKeyDown("e") && inv.voll()==false)
        {
            Item i = (Item)getOneIntersectingObject(Item.class);
            inv.einfügen(i);
            getWorld().removeObject(i);
        }
    }

    /**
     * 
     */
    public void öffnen()
    {
        if (Greenfoot.isKeyDown("o"))
        {
            Tür tür;
            if(getOneTouchingObject("l", Tür.class,4) != null && left==true) 
            {
                tür = (Tür) getOneTouchingObject("l", Tür.class,4);
            }
            else if(getOneTouchingObject("r", Tür.class,4) != null && left==false) 
            {
                tür = (Tür) getOneTouchingObject("r", Tür.class,4);
            }
            else 
            {
                return;
            }

            for(int i=0; i<inv.größe(); i++)
            {
                Item a = inv.ausgeben(i);
                if(a != null)
                {
                    if(a.getClass()==Schlüssel.class && tür.offen()==false)
                    {
                        tür.open();
                        new Audioplayer().play("door_open.wav");
                    }
                    if(tür.offen()==true)
                    {
                        return;
                    }
                    if(a.getClass()!=Schlüssel.class)
                    {
                        inv.einfügen(a);
                    }
                }
            }
        }        
    }

    /**
     * 
     */
    public int getLeben()
    {
        return Leben;
    }

    /**
     * 
     */
    public int getLuft()
    {
        return Luft;
    }

    /**
     * 
     */
    public void getroffenWerden()
    {
        if(getOneIntersectingObject(Munition.class)!=null)
        {
            Leben=Leben-5;
            Munition m = (Munition)getOneIntersectingObject(Munition.class);
            getWorld().removeObject(m);
        }
    }

    /**
     * 
     */
    public void verbrennen()
    {
        if(getOneIntersectingObject(Feuer.class)!=null)
        {
            Leben= Leben-15;
        }
    }

    /**
     * 
     */
    public void zurücksetzen()
    {
        if(Greenfoot.isKeyDown("r")||Leben<=0)
        {
            World world = getWorld();
            Level w = (Level)world;
            Start start = w.start;
            w.setzeSpieler(start.getX(), start.getY());
            setImage("Joppa_links.png");
            Leben = 100;
            Luft = 100;
        }
    }

    /**
     * 
     */
    public void bewegen()
    {
        Block p = (Block)getOneIntersectingObject(Block.class);

        if(Greenfoot.isKeyDown("left"))
        {
            for(int i=V; i>0; i--)
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
            left = true;
            setImage("Joppa_links.png");
        }

        if(Greenfoot.isKeyDown("right"))
        {
            for(int i=V; i>0; i--)
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
            left = false;
            setImage("Joppa_rechts.png");
        }

        if(Greenfoot.isKeyDown("up"))
        {
            for(int i=2*V; i>0; i--)
            {
                Block o = (Block)getOneTouchingObject("o", Block.class, i);
                if(getOneIntersectingObject(Leiter.class)!=null && (o == null || o.durchlässig()==true))
                {
                    setLocation(getOneIntersectingObject(Leiter.class).getX(),getY()-i);
                    break;
                }
                if(getOneIntersectingObject(Wasser.class)!=null && o instanceof Wasser)
                {
                    setLocation(getX(),getY()-i);
                    break;
                }
            }
        }

        if(Greenfoot.isKeyDown("down"))
        {
            for(int i=2*V; i>=0; i--)
            {
                if(getOneTouchingObject("u", Leiter.class, i)!=null)
                {
                    setLocation(getX(),getY()+i);
                    break;
                }
                Block u = (Block)getOneTouchingObject("u", Block.class, i);
                if(getOneIntersectingObject(Wasser.class)!=null && u instanceof Wasser)
                {
                    setLocation(getX(),getY()+i);
                    break;
                }
            }
        }

        if((Block)getOneTouchingObject("o", Block.class, V) instanceof Wasser)
        {
            Luft=Luft-2;
            if(Luft <= 1)
            {
                Leben=Leben-5;
            }
        }

        if(getOneTouchingObject("o",Wasser.class, V)==null)
        {
            Luft=100;
        }

        if((Block)getOneTouchingObject("o", Block.class, V)==null && Greenfoot.isKeyDown("space"))
        {
            Block l = (Block)getOneTouchingObject("l", Block.class, V);
            Block r = (Block)getOneTouchingObject("r", Block.class, V);
            Block u = (Block)getOneTouchingObject("u", Undurchfallbar.class, 1);
            Block v = (Block)getOneTouchingObject("u", Leiter.class, 1);
            if(u !=null || v != null)
            {
                setLocation(getX(),getY()-3*V);
                setLocation(getX(),getY());
                Fallhöhe = 0;
            }
            if(getOneIntersectingObject(Wasser.class)!=null && (l!=null || r!=null))
            {
                setLocation(getX(),getY()-3*V);
                setLocation(getX(),getY());
                Fallhöhe = 0;
            }
        }
    }

    /**
     * 
     */
    public void fallen()
    {
        if(getOneIntersectingObject(Leiter.class)!=null || getOneIntersectingObject(Wasser.class)!=null)
        {
            return;
        }

        for(int i = 0; i<=V; i++)
        {
            Actor u = getOneTouchingObject("u",Undurchfallbar.class, i);
            if(u == null)
            {
                int h = i+1;
                Actor v = getOneTouchingObject("u",Undurchfallbar.class, h);
                if(i == V || v != null)
                {
                    setLocation(getX(), getY()+i);
                    u = null;
                    v = null;
                    return;
                }
            }
        }
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
                correctDirection = iActor.getY() >= getY();
            } else if(x == "l") {
                correctDirection = iActor.getX() <= getX();
            } else if(x == "o") {
                correctDirection = iActor.getY() <= getY();
            } else if(x == "r") {
                correctDirection = iActor.getX() >= getX();
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
