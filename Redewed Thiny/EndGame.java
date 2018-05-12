import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndGame extends World
{

    /**
     * Constructor for objects of class EndGame.
     * 
     */
    public EndGame()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        prepare();
    }
    private void prepare(){
        Actor wintext = new Actor(){
            public void act() 
            {
                setImage(new GreenfootImage("YOU WIN", 50, Color.WHITE, Color.BLACK));
            }
        };
        addObject(wintext, 400, 300);
    }
}
