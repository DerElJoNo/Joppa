
public class Inventar  
{
    Item[] inventar;
    final int inventargröße = 8;
    
    public Inventar()
    {
        inventar = new Item[inventargröße];
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
    
    public Item ausgeben(int i) 
    {
        Item result = inventar[i];
        inventar[i]=null;
        return result;
    }
    
    
}
