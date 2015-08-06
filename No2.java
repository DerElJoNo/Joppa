import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class No2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class No2 extends Level
{

    /**
     * Constructor for objects of class No2.
     * 
     */
    public No2()
    {    
        no2();    
        setzeStandart();
        setzeSpieler(unit(30), unit(34));
        setLevel(2);
    }
    
    public void no2()
    {
        addObject(new Ziel(), unit(35), unit(34));
        addObject(new Ziel(), unit(2), unit(25));
        addObject(new Wand(), unit(54), unit(28));
        Tür t = new Tür();
        addObject(t, unit(47), unit(34));
        t.open();
        addObject(new Start(), unit(51), unit(34));
        
        newWandRow(33,24,33,34);
        newWandRow(1,23,54,23);
        newWandRow(34,32,46,32);
        newWandRow(47,29,47,33);
        newWandRow(40,28,52,28);
        newWandRow(40,24,40,27);
        newLeiterRow(53,28,53,34);
        newLeiterRow(27,27,27,34);
        
        newWandRow(25, 28, 25, 34);
        newWandRow(22, 27, 26, 27);
        newWandRow(29, 27, 32, 32);
        addObject(new Wand(), unit(28), unit(27));
        addObject(new Wand(), unit(29), unit(24));
        addObject(new Wand(), unit(29), unit(25));
        addObject(new Tür(), unit(29), unit(26));
        addObject(new Kuchen(), unit(31), unit(26));
        newLeiterRow(21, 27, 21, 30);
        newWandRow(15, 32, 21, 32);
        newWandRow(15, 31, 16, 31);
        addObject(new Wand(), unit(18), unit(31));
        newWandRow(20, 31, 21, 31);
        newWandRow(19, 33, 19, 34);
        newLeiterRow(14, 31, 14, 34);
        newWandRow(1, 26, 6, 26);
        newLeiterRow(7, 26, 7, 33);
        newWandRow(6, 34, 8, 34);
        addObject(new Wand(), unit(4), unit(34));
        newWandRow(1, 34, 2, 34);
        addObject(new Wand(), unit(4), unit(24));
        addObject(new Tür(), unit(4), unit(25));
        addObject(new Schlüssel(), unit(2), unit(33));
        addObject(new Schlüssel(), unit(15), unit(30));
        newFeuerRow(20, 34, 24, 34);
        addObject(new Feuer(), unit(3), unit(34));
        addObject(new Feuer(), unit(5), unit(34));
        addObject(new Feuer(), unit(17), unit(31));
        addObject(new Feuer(), unit(19), unit(31));
    }
}