import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    }
    
    public Inventar inv()
    {
        return inv;
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
            if(getOneIntersectingObject(Tür.class) != null) 
            {
                tür = (Tür) getOneIntersectingObject(Tür.class);
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
    public int Leben()
    {
        return Leben;
    }
    
    /**
     * 
     */
    public int Luft()
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
        }
    }
    
    /**
     * 
     */
    public void verbrennen()
    {
        if(getOneIntersectingObject(Feuer.class)!=null)
        {
            Leben= Leben-20;
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
           w.setzeSpieler();
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
                Block l = (Block)getOneTouchingObject("l", Block.class, i);
                if(l==null || l.durchlässig()==true)
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
                Block r = (Block)getOneTouchingObject("r", Block.class, i);
                if(r==null || r.durchlässig()==true)
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
            for(int i=V; i>0; i--)
            {
                Block o = (Block)getOneTouchingObject("o", Block.class, i);
                if(getOneIntersectingObject(Leiter.class)!=null && (o == null || o.durchlässig()==true))
                {
                    setLocation(getX(),getY()-i);
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
            for(int i=V; i>0; i--)
            {
                Block u = (Block)getOneTouchingObject("u", Block.class, i);
                if(u!=null && u.durchlässig()==true)
                {
                    setLocation(getX(),getY()+V);
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
            Block u = (Block)getOneTouchingObject("u", Block.class, 1);
            if(u instanceof Wand || u instanceof Leiter)
            {
                setLocation(getX(),getY()-3*V);
                setLocation(getX(),getY());
            }
            if(getOneIntersectingObject(Wasser.class)!=null && (l!=null || r!=null))
            {
                setLocation(getX(),getY()-3*V);
                setLocation(getX(),getY());
            }
        }
    }
    
    /**
     * 
     */
    public void fallen()
    {
        for(int i = V; i>0; i--)
        {
            Block u = (Block)getOneTouchingObject("u",Block.class, i);
            if(u instanceof Wand || u instanceof Leiter || u instanceof Wasser)
            {
                int h=i-1;
                Block b =(Block)getOneTouchingObject("u",Block.class,h);
                if(!(b instanceof Wand || b instanceof Leiter || b instanceof Wasser))
                {
                    if(Fallhöhe>=4)
                    {
                        Leben= Leben-2*((Fallhöhe*175/104)-(Fallhöhe*Fallhöhe*7/208)-(5/26));
                    }
                    Fallhöhe=0;
                    setLocation(getX(),getY()+h);
                    break;
                }
            }
            else
            {
                setLocation(getX(),getY()+V);
                Fallhöhe++;
                break;
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
}
