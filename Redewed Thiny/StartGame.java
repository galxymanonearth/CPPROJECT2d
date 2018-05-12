import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/**
 * Write a description of class StartGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartGame extends World
{

    /**
     * Constructor for objects of class StartGame.
     * 
     */
    public StartGame()
    {    
        super(800, 600, 1);
        Actor starter = new Actor(){
                public void act() 
                {
                    setImage(new GreenfootImage("Press \"Enter\" to Start", 50, Color.WHITE, Color.BLACK));
                }
            };
            Actor restarter = new Actor(){
                public void act() 
                {
                    setImage(new GreenfootImage("Press \"R\" to reset", 25, Color.WHITE, Color.BLACK));
                }
            };
            addObject(starter,400,300);
            addObject(restarter,400,375);
    }
    public void act(){
        if(Greenfoot.isKeyDown("enter"))
            Greenfoot.setWorld(new PlatformWorld());
    }
    
}
