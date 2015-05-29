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
    public int Schlüssel;
    public Inventar inv;
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
        gehen();
        zurücksetzen();
        fallen();
        verbrennen();
        getroffenWerden();
        schwimmen();
        öffnen();
        aufsammeln();
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
        if(getOneObjectAtOffset(-1,0,Tür.class)!=null)
        {
            if(Greenfoot.isKeyDown("o") && Schlüssel >= 0)
            {
                Tür tür = (Tür)getOneObjectAtOffset(-1,0,Tür.class);
                tür.open();
                Schlüssel--;
            }
        }
        
    }
    
    /**
     * 
     */
    public void schwimmen()
    {
        if(Greenfoot.isKeyDown("left")&& getOneObjectAtOffset(-1,0,Wasser.class)!=null)
        {
            setLocation(getX()-1,getY());
            setImage("Joppa_links.png");
        }
        
        if(Greenfoot.isKeyDown("right")&& getOneObjectAtOffset(1,0,Wasser.class)!=null)
        {
            setLocation(getX()+1,getY());
            setImage("Joppa_rechts.png");
        }
        
        if(Greenfoot.isKeyDown("up") && getOneObjectAtOffset(0,-1,Wasser.class)!=null)
        {
            setLocation(getX(),getY()-1);
        }
        
        if(Greenfoot.isKeyDown("down") && getOneObjectAtOffset(0,1,Wasser.class)!=null)
        {
            setLocation(getX(),getY()+1);
        }
        
        if(Greenfoot.isKeyDown("space") && getOneObjectAtOffset(0,0,Wasser.class)!=null)
        {
            if(getOneObjectAtOffset(1,0,Wand.class)!=null)
            {
                setImage("Joppa_rechts.png");
                setLocation(getX(),getY()-1);
            }
            
            if(getOneObjectAtOffset(-1,0,Wand.class)!=null)
            {
                setImage("Joppa_links.png");
                setLocation(getX(),getY()-1);
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
        
        if(getOneObjectAtOffset(0,0,Wasser.class)==null)
        {
            Luft=100;
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
    
    /**
     * 
     */
    public void zurücksetzen()
    {
        if(Greenfoot.isKeyDown("r")||Leben<=0)
        {
           setLocation(33,18);
           setImage("Joppa_links.png");
           Leben=100;
        }
    }
    
    /**
     * 
     */
    public void gehen()
    {
        if(Greenfoot.isKeyDown("left")&& getOneObjectAtOffset(-1,0,Wand.class)==null)
        {
            setLocation(getX()-1,getY());
            setImage("Joppa_links.png");
        }
        
        if(Greenfoot.isKeyDown("right")&& getOneObjectAtOffset(1,0,Wand.class)==null)
        {
            setLocation(getX()+1,getY());
            setImage("Joppa_rechts.png");
        }
        
        if(getOneObjectAtOffset(0,0,Leiter.class)!=null && getOneObjectAtOffset(0,-1,Wand.class)==null)
        {
            if(Greenfoot.isKeyDown("up"))
            {
                setLocation(getX(),getY()-1);
            }
        }
        
        if(getOneObjectAtOffset(0,1,Leiter.class)!=null && getOneObjectAtOffset(0,0,Wand.class)==null)
        {
            if(Greenfoot.isKeyDown("down"))
            {
                setLocation(getX(),getY()+1);
            }
        }
        
        if(getOneObjectAtOffset(0,-1,Wand.class)==null && Greenfoot.isKeyDown("space"))
        {
            if(getOneObjectAtOffset(0,1,Wand.class)!=null && getOneObjectAtOffset(0,0,Leiter.class)==null || getOneObjectAtOffset(0,1,Leiter.class)!=null)
            {
                setLocation(getX(),getY()-2);
                setLocation(getX(),getY());
            }
        }
    }
}
