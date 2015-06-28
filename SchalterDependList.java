public class SchalterDependList
{
    Elektronik[] dependList;
    public int größe;
    public SchalterDependList(int i)
    {
        dependList = new Elektronik[i];
        größe = i;
    }
    
    public void einfügen(Elektronik e)
    {
        for(int i = 0; i < größe; i++)
        {
            if(dependList[i]==null)
            {
                dependList[i] = e;
            }
        }
    }
    
    public int größe()
    {
        return größe;
    }
    
    public Elektronik ausgeben(int i) 
    {
        Elektronik result = dependList[i];
        dependList[i] = null;
        return result;
    }
}
    

