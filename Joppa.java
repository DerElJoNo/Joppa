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
        if(getOneObjectAtOffset(0,0,Item.class)!=null && Greenfoot.isKeyDown("q"))
        {
            Item i = (Item)getOneObjectAtOffset(0,0,Item.class);
            if(i.verzehr()==true && 100 >= i.hungerpunkte()+ Leben)
            {
                Leben = Leben + i.hungerpunkte();
                getWorld().removeObject(i);
            }
            if(i.verzehr()==true && 100 < i.hungerpunkte()+ Leben)
            {
                Leben = 100;
                getWorld().removeObject(i);
            }
        }
    }
    
    /**
     * 
     */
    public void setzen()
    {
        for(int i=0; i<inv.größe()+1; i++)
        {
             if(Greenfoot.isKeyDown(Integer.toString(i+1)))
             {
                 Item a = inv.ausgeben(i);
                 if(a!=null)
                 {
                     if(left==true)
                     {
                         getWorld().addObject(a,getX()-1,getY());
                     }
                     if(left!=true)
                     {
                         getWorld().addObject(a,getX()+1,getY());
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
        if(getOneObjectAtOffset(0,0,Item.class)!=null && Greenfoot.isKeyDown("e"))
        {
            Item i = (Item)getOneObjectAtOffset(0,0,Item.class);
            inv.einfügen(i);
            getWorld().removeObject(i);
        }
    }
    
    /**
     * 
     */
    public void öffnen()
    {
        if(getOneObjectAtOffset(-1,0,Tür.class)!=null && Greenfoot.isKeyDown("o"))
        {
            Tür tür = (Tür)getOneObjectAtOffset(-1,0,Tür.class);
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
        
        if(getOneObjectAtOffset(1,0,Tür.class)!=null && Greenfoot.isKeyDown("o"))
        {
            Tür tür = (Tür)getOneObjectAtOffset(1,0,Tür.class);
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
        if(getOneObjectAtOffset(0,0,Munition.class)!=null)
        {
            Leben=Leben-5;
        }
    }
    
    /**
     * 
     */
    public void verbrennen()
    {
        if(getOneObjectAtOffset(0,0,Feuer.class)!=null)
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
        }
    }
    
    /**
     * 
     */
    public void bewegen()
    {
        Block o = (Block)getOneObjectAtOffset(0,-1,Block.class);
        Block u = (Block)getOneObjectAtOffset(0,1,Block.class);
        Block r = (Block)getOneObjectAtOffset(1,0,Block.class);
        Block l = (Block)getOneObjectAtOffset(-1,0,Block.class);
        Block p = (Block)getOneObjectAtOffset(0,0,Block.class);
        
        if(Greenfoot.isKeyDown("left"))
        {
            if(l==null)
            {
                setLocation(getX()-1,getY());
            }
            if(l!=null)
            {
                if(l.durchlässig()==true)
                {
                    setLocation(getX()-1,getY());
                }
            }
            left = true;
            setImage("Joppa_links.png");
        }
        
        if(Greenfoot.isKeyDown("right"))
        {
            if(r==null)
            {
                setLocation(getX()+1,getY());
            }
            if(r!=null)
            {
                if(r.durchlässig()==true)
                {
                    setLocation(getX()+1,getY());
                }
            }
            left = false;
            setImage("Joppa_rechts.png");
        }
        
        if(Greenfoot.isKeyDown("up"))
        {
            if(o!=null && o.gravitation()==false && p!=null && p.gravitation==false)
            {
                setLocation(getX(),getY()-1);
            }
        }
        
        if(Greenfoot.isKeyDown("down"))
        {
            if(u!=null && u.durchlässig()==true)
            {
                setLocation(getX(),getY()+1);
            }
        }
        
        if(getOneObjectAtOffset(0,-1,Wasser.class)!=null && getOneObjectAtOffset(0,0,Wasser.class)!=null)
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
        
        if(getOneObjectAtOffset(0,-1,Wand.class)==null && Greenfoot.isKeyDown("space"))
        {
            if(getOneObjectAtOffset(0,1,Wand.class)!=null && getOneObjectAtOffset(0,0,Leiter.class)==null || getOneObjectAtOffset(0,1,Leiter.class)!=null)
            {
                setLocation(getX(),getY()-2);
                setLocation(getX(),getY());
            }
        }
        
        if(getOneObjectAtOffset(0,-1,Wand.class)==null && Greenfoot.isKeyDown("space"))
        {
            if(getOneObjectAtOffset(0,1,Wand.class)!=null && getOneObjectAtOffset(0,0,Leiter.class)==null || getOneObjectAtOffset(0,1,Leiter.class)!=null)
            {
                setLocation(getX(),getY()-2);
                setLocation(getX(),getY());
            }
            if(getOneObjectAtOffset(0,0,Wasser.class)!=null && (getOneObjectAtOffset(1,0,Wand.class)!=null || getOneObjectAtOffset(-1,0,Wand.class)!=null))
            {
                setLocation(getX(),getY()-2);
                setLocation(getX(),getY());
            }
        }
    }
    
    /**
     * 
     */
    public void fallen()
    {
        if(getOneObjectAtOffset(0,1,Wand.class)==null && getOneObjectAtOffset(0,1,Leiter.class)==null && getOneObjectAtOffset(0,0,Wasser.class)==null)
        {
            setLocation(getX(),getY()+1);
            Fallhöhe++;
            if(getOneObjectAtOffset(0,1,Wand.class)!=null || getOneObjectAtOffset(0,1,Leiter.class)!=null)
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
