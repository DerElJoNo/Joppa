
public class Inventar  
{
    Item[] inventar;
    final int inventargröße = 9;
    
    public Inventar()
    {
        inventar = new Item[inventargröße];
    }
    
    public int größe()
    {
        return inventargröße;
    }
    
    public boolean einfügen(Item item) 
    {
        for(int i=0; i<inventargröße; i++)
        {
            if(inventar[i]==null)
            {
                inventar[i] = item;
                return true;
            }
        }
        return false;
    }
    
    public boolean voll()
    {
        if(inventar[8]==null)
        {
            return false;
        }
        return true;
    }
    
    public Item ausgeben(int i) 
    {
        Item result = inventar[i];
        inventar[i]=null;
        return result;
    }
}
