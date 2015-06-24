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
        Block l = (Block)getOneTouchingObject("l", Block.class);
        Block r = (Block)getOneTouchingObject("r", Block.class);
        Block o = (Block)getOneTouchingObject("o", Block.class);
        Block u = (Block)getOneTouchingObject("u", Block.class);
        
        if(Greenfoot.isKeyDown("left"))
        {
            setLocation(getX()-V,getY());
            if(l!=null && l.durchlässig()==false)
            {
                setLocation(getX()+V,getY());
            }
            left = true;
            setImage("Joppa_links.png");
        }
        
        if(Greenfoot.isKeyDown("right"))
        {
            setLocation(getX()+V,getY());
            if(r!=null && r.durchlässig()==false)
            {
                setLocation(getX()-V,getY());
            }
            left = false;
            setImage("Joppa_rechts.png");
        }
        
        if(Greenfoot.isKeyDown("up"))
        {
            if(o!=null && o.gravitation()==false && p!=null && p.gravitation==false)
            {
                setLocation(getX(),getY()-V);
            }
        }
        
        if(Greenfoot.isKeyDown("down"))
        {
            if(u!=null && u.durchlässig()==true)
            {
                setLocation(getX(),getY()+V);
            }
        }
        
        if(o instanceof Wasser)
        {
            Luft=Luft-2;
            if(Luft <= 1)
            {
                Leben=Leben-5;
            }
        }
        
        if(getOneTouchingObject("o",Wasser.class)==null)
        {
            Luft=100;
        }
        
        if(o==null && Greenfoot.isKeyDown("space"))
        {
            if(u instanceof Wand || u instanceof Leiter)
            {
                setLocation(getX(),getY()-4*V);
                setLocation(getX(),getY());
            }
            if(getOneIntersectingObject(Wasser.class)!=null && (l!=null || r!=null))
            {
                setLocation(getX(),getY()-4*V);
                setLocation(getX(),getY());
            }
        }
    }
    
    /**
     * 
     */
    public void fallen()
    {
        Block u = null;
        if(getOneTouchingObject("u",Wand.class)==null && getOneTouchingObject("u",Leiter.class)==null && getOneTouchingObject("u",Wasser.class)==null)
        {
            Fallhöhe++;
            setLocation(getX(),getY()+2*V);
            u = (Block)getOneTouchingObject("u",Block.class);
            if(u!=null)
            {
                if(Fallhöhe>=4)
                {
                   Leben= Leben-2*((Fallhöhe*175/104)-(Fallhöhe*Fallhöhe*7/208)-(5/26));
                }
                Fallhöhe=0;
            }
        }
    }
    
    public Actor getOneTouchingObject(String x, Class b)
    {
        Actor a = null;
        int XChange = 0;
        int YChange = 0;
        if(x == "u") {
            YChange = V;
        } else if(x == "l") {
            XChange = -V;
        } else if(x == "o") {
            YChange = -V;
        } else if(x == "r") {
            XChange = V;
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
