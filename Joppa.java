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
        if ( Greenfoot.isKeyDown("o") )
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
        Block l = null;
        Block r = null;
        Block o = null;
        Block u = null;
        
        if(p!=null && p.getX()<=getX())
        {
            l = p;
        }
        if(p!=null && p.getX()>=getX())
        {
            r = p;
        }
        if(p!=null && p.getY()<=getY())
        {
            o = p;
        }
        if(p!=null && p.getY()>=getY())
        {
            u = p;
        }
        
        if(Greenfoot.isKeyDown("left"))
        {
            if(l==null)
            {
                setLocation(getX()-8,getY());
            }
            if(l!=null)
            {
                if(l.durchlässig()==true)
                {
                    setLocation(getX()-8,getY());
                }
            }
            left = true;
            setImage("Joppa_links.png");
        }
        
        if(Greenfoot.isKeyDown("right"))
        {
            if(r==null)
            {
                setLocation(getX()+8,getY());
            }
            if(r!=null)
            {
                if(r.durchlässig()==true)
                {
                    setLocation(getX()+8,getY());
                }
            }
            left = false;
            setImage("Joppa_rechts.png");
        }
        
        if(Greenfoot.isKeyDown("up"))
        {
            if(o!=null && o.gravitation()==false && p!=null && p.gravitation==false)
            {
                setLocation(getX(),getY()-8);
            }
        }
        
        if(Greenfoot.isKeyDown("down"))
        {
            if(u!=null && u.durchlässig()==true)
            {
                setLocation(getX(),getY()+8);
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
        
        if(getOneObjectAtOffset(0,-1,Wasser.class)==null)
        {
            Luft=100;
        }
        
        if(o==null && Greenfoot.isKeyDown("space"))
        {
            if(u instanceof Wand || u instanceof Leiter)
            {
                setLocation(getX(),getY()-32);
                setLocation(getX(),getY());
            }
            if(getOneIntersectingObject(Wasser.class)!=null && (l!=null || r!=null))
            {
                setLocation(getX(),getY()-32);
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
        Block p = null;
        
        for(int i=0; i<getIntersectingObjects(Block.class).size() ; i++)
        {
            p = (Block)getIntersectingObjects(Block.class).get(i);
            if(p.getY()>getY() &&(p instanceof Wand || p instanceof Leiter || p instanceof Wasser ))
            {
                u = p;
            }
            if(u==null)
            {
                setLocation(getX(),getY()+16);
                Fallhöhe++;
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
    }
}
