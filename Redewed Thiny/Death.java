import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Death extends World
{

    /**
     * Constructor for objects of class EndGame.
     * 
     */
    public Death()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        prepare();
    }

    private void prepare(){
        Actor wintext = new Actor(){
                PlatformJumper control = new PlatformJumper();

                int hundred = control.hundred + 1;
                public void act() 
                {
                    setImage(new GreenfootImage("YOU Died You Had " + (100-hundred) + " rooms left", 50, java.awt.Color.WHITE, java.awt.Color.BLACK));
                }
            };
        addObject(wintext, 400, 300);
    }
}
