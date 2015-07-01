import greenfoot.*;
/**
 * Write a description of class Audioplayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Audioplayer  
{
    /**
     * Constructor for objects of class Audioplayer
     */
    public Audioplayer()
    {
        
    }
    
    int backgroundVolume = 50;
    int soundEffectVolume = 80;
    
    public void setBackgroundVolume(int v)
    {
        backgroundVolume = v;
    }
    
    public void setSoundEffectVolume(int v)
    {
        soundEffectVolume = v;
    }
    
    public void playBackgroundmusic()
    {
        GreenfootSound background1 = new GreenfootSound("Backgroundmusic1.wav");
        GreenfootSound background2 = new GreenfootSound("Backgroundmusic2.wav");
        GreenfootSound backgroundmusic = background1;
        
        while(backgroundmusic.isPlaying() == false)
        {
            int i = Greenfoot.getRandomNumber(99);
            
            if(i <= 50)
            {
                backgroundmusic = background1;
            }
            if(i > 50 && i <= 99)
            {
                backgroundmusic = background2;
            }
            
            backgroundmusic.setVolume(backgroundVolume);
            backgroundmusic.play();
            
            if(backgroundmusic.isPlaying() == false)
            {
                playBackgroundmusic();
            }
        }
    }
    
    public void play(String s)
    {
        GreenfootSound sound = new GreenfootSound(s);
        sound.setVolume(soundEffectVolume);
        sound.play();
    }
}
